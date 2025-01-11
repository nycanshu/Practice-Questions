//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int len = 0;
        int l = 0, r = 0, n = s.length();
        int[] freq = new int[128];
        
        while(r < n){
            char ch = s.charAt(r);
            
            while (freq[ch] != 0) {
                freq[s.charAt(l)] = 0; 
                l++; 
            }
            freq[ch] = 1;
            len = Math.max(len, r - l + 1);
            r++;
        }
        return len;
    }
}