//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0)
        {
            String s;
            s = br.readLine();
            
            Solution ob = new Solution();
            
            System.out.println(ob.modify(s));    
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    String modify(String S)
    {
        // Create a StringBuilder object from the input string
        StringBuilder sb = new StringBuilder(S);
        
        // Use the setLength method to remove trailing spaces
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.setLength(sb.length() - 1);
        }
        
        // Use the replace method to remove all spaces from the string
        return sb.toString().replace(" ", "");
    }
}