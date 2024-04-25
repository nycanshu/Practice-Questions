//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int[] ans = ob.FindExitPoint(n, m, matrix);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] FindExitPoint(int n, int m, int[][] matrix) {
        // code here
         int[] exitPoint = new int[2];
        int i = 0, j = 0;
        int dir = 0; // 0 -> right, 1 -> down, 2 -> left, 3 -> up

        while (true) {
            if (matrix[i][j] == 1) {
                // Change direction to the right
                dir = (dir + 1) % 4;
                matrix[i][j] = 0; // Change the 1 to 0
            }

            if (dir == 0) { // Move right
                j++;
            } else if (dir == 1) { // Move down
                i++;
            } else if (dir == 2) { // Move left
                j--;
            } else if (dir == 3) { // Move up
                i--;
            }

            // Check if exit point reached
            if (i < 0 || i >= n || j < 0 || j >= m) {
                if (dir == 0) {
                    exitPoint[0] = i;
                    exitPoint[1] = j - 1;
                } else if (dir == 1) {
                    exitPoint[0] = i - 1;
                    exitPoint[1] = j;
                } else if (dir == 2) {
                    exitPoint[0] = i;
                    exitPoint[1] = j + 1;
                } else if (dir == 3) {
                    exitPoint[0] = i + 1;
                    exitPoint[1] = j;
                }
                break;
            }
        }
        return exitPoint;
    }
}