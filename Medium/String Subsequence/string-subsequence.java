//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s1;
            s1 = br.readLine();

            String s2;
            s2 = br.readLine();

            Solution obj = new Solution();
            int res = obj.countWays(s1, s2);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public int countWays(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        
        // Base case: empty string is subsequence of any string
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % 1000000007;
            }
        }
        
        return dp[n][m];
    }
}