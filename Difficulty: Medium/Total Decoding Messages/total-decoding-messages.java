//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String digits = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countWays(digits);
            out.println(ans);

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int countWays(String digits) {
        if (digits == null || digits.length() == 0 || digits.charAt(0) == '0') {
            return 0;
        }

        int n = digits.length();
        int[] dp = new int[n + 1];
        
        // Base case
        dp[0] = 1;
        dp[1] = 1;  // First character is valid (already checked for '0')

        for (int i = 2; i <= n; i++) {
            int singleDigit = digits.charAt(i - 1) - '0';
            int twoDigit = Integer.parseInt(digits.substring(i - 2, i));

            // Single digit case (1-9)
            if (singleDigit >= 1) {
                dp[i] += dp[i - 1];
            }

            // Two-digit case (10-26)
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}