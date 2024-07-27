//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int LCS(String s, String p, int i,int j, int n, int[][] dp)
    {
        if(i>=n||j>=n) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==p.charAt(j))
        {
            dp[i][j]=Math.max(dp[i][j],1+LCS(s,p,i+1,j+1,n,dp));
        }
        else
         dp[i][j]=Math.max(LCS(s,p,i+1,j,n,dp),LCS(s,p,i,j+1,n,dp));
        return dp[i][j];
    }
    static int countMin(String str)
    {
        StringBuilder sb=new StringBuilder(str);
        sb.reverse();
        int n=str.length();
        int[][] dp=new int[n+5][n+5];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i],-1);
        int lcs=LCS(str,sb.toString(),0,0,str.length(),dp);
        return n-lcs;
    }
}