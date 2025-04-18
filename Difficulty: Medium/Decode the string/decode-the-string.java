//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s = in.readLine();

            Solution ob = new Solution();
            out.println(ob.decodeString(s));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends



class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();  // Stack for repeat counts
        Stack<StringBuilder> strStack = new Stack<>();  // Stack for strings
        StringBuilder current = new StringBuilder();  // Keep the track of current String 
        int num = 0;  // Current number is being parsed
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') { // pushing number and the current String and resetting it
                numStack.push(num);
                strStack.push(current);
                num = 0;
                current = new StringBuilder();
            } else if (c == ']') { // poping the elements from the stack and after that appending the string 
                int repeat = numStack.pop();
                StringBuilder temp = current;
                current = strStack.pop();
                for (int i = 0; i < repeat; i++) {
                    current.append(temp);
                }
            } else {
                current.append(c);
            }
        }
        return current.toString(); // converting in to string so that our result should be in string
    }
}