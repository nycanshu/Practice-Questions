//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            String s1 = sc.next(); // Take both the strings as input
            String s2 = sc.next();

            Solution obj = new Solution();

            // Call the lcs function with the lengths of the strings as
            // parameters
            System.out.println(obj.lcs(s1, s2));
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    
    static int f(int i, int j, String s1, String s2, int dp[][]){
        if(i==0 || j==0)return 0;
        
        if(dp[i][j]!=-1)return dp[i][j];
        
        
        if(s1.charAt(i-1)==s2.charAt(j-1)){
           return dp[i][j]= 1+f(i-1,j-1, s1,s2,dp);
        }else {
            return dp[i][j]= Math.max(f(i-1,j, s1,s2,dp),f(i,j-1, s1,s2,dp));
        }
    }
    
    static int lcs(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n+1][m+1];
        for(int a[]:dp)Arrays.fill(a,-1);
        return f(n, m, s1, s2,dp);
        
    }
}