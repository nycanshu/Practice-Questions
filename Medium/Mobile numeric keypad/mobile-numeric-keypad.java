//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.getCount(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long getCount(int n) {
        if (n == 1) return 10;
        
        int[][] transitions = {
            {0, 8},         // 0
            {1, 2, 4},      // 1
            {1, 2, 3, 5},   // 2
            {2, 3, 6},      // 3
            {1, 4, 5, 7},   // 4
            {2, 4, 5, 6, 8},// 5
            {3, 5, 6, 9},   // 6
            {4, 7, 8},      // 7
            {5, 7, 8, 9, 0},// 8
            {6, 8, 9}       // 9
        };

        long[][] dp = new long[n + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int length = 2; length <= n; length++) {
            for (int digit = 0; digit < 10; digit++) {
                for (int nextDigit : transitions[digit]) {
                    dp[length][nextDigit] += dp[length - 1][digit];
                }
            }
        }

        long result = 0;
        for (int digit = 0; digit < 10; digit++) {
            result += dp[n][digit];
        }

        return result;
    }
}
