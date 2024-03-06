//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<Integer> search(String pattern, String text) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = pattern.length();
        for(int i=0; i<=text.length()-n; i++) {
            if(text.charAt(i) != pattern.charAt(0)) 
                continue;
            if(pattern.equals(text.substring(i, i+n))) 
                res.add(i+1);
        }
        return res;
    }
}