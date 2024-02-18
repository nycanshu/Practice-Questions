//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String longestCommonPrefix(String arr[], int n) {
        if (n == 0) return "-1"; // Empty array
        
        String prefix = arr[0]; // Start with the first string as the initial prefix
        
        for (int i = 1; i < n; i++) {
            while (arr[i].indexOf(prefix) != 0) { // Keep removing characters from the prefix until it is a prefix of the current string
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "-1"; // If prefix becomes empty, no common prefix exists
            }
        }
        
        return prefix;
    }
}
