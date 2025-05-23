class Solution {
    static int noOfWays(int m, int n, int x) {
        // code here
        int [][][] dp = new int [m + 1][n + 1][x + 1];
        for (int [][] dd : dp) {
            for (int [] d : dd) {
                Arrays.fill(d, -1);
            }
        }
        return findWays(m, n, x, dp);
    }
    
    static int findWays(int m, int n, int x, int [][][] dp) {
        if (n == 0 && x == 0) {
            return 1;
        }
        if (n == 0 || x < 0) {
            return 0;
        }
        if (dp[m][n][x] != -1) {
            return dp[m][n][x];
        }
        int totalWays = 0;
        for (int face = 1; face <= m; face++) {
            totalWays += findWays(m, n - 1, x - face, dp);
        }
        return dp[m][n][x] = totalWays;
    }
}