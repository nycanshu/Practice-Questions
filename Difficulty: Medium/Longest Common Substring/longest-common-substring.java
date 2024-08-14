//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestCommonSubstr(String str1, String str2) {
        // code here
        int ans =0;
        for(int i=0;i<str1.length()+1;i++){
            for(int j=i+1;j<str1.length()+1;j++){
                String temp = str1.substring(i,j);
                if(str2.contains(temp)){
                    ans = Math.max(ans,temp.length());
                }
            }
            
        }
        return ans;
    }
}