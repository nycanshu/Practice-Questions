//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String S){
        // code here
        Stack<Character> st = new Stack<>();
        Stack<Integer> index = new Stack<>();
        index.push(-1);
        
        int ans = 0;
        
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            
            if(ch == '(') {
                index.push(i);
                st.push(ch);
            }
            
            else if(ch == ')' && !st.isEmpty()) {
                st.pop();
                index.pop();
                ans = Math.max(ans, i - index.peek());
            } 
            
            else index.push(i);
        }
        
        return ans;
    
    }
}