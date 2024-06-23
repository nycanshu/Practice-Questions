//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            ArrayList<Integer> result = ob.bracketNumbers(S);
            for (int value : result) out.print(value + " ");
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Integer> bracketNumbers(String str) {
        
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer>  al = new ArrayList<Integer> ();
        int count=1;
        
        for(char s:str.toCharArray())
        {
            if(s=='(')
            {
                stack.push(count);
                al.add(count);
                count++;
            }
            else if(s==')')
                al.add(stack.pop());
        }
        
        return al;
    }
};