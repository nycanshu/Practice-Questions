//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int[][] a = new int[n][n];
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            String ans = ob.pattern(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String pattern(int[][] arr) {
        int n = arr.length;
        int minr = Integer.MAX_VALUE;
        
       
        for (int r = 0; r < n; r++) {
            if (isPalindromeRow(arr, r, n)) {
                minr = r;
                return minr + " R";
            }
        }
        
        int minc = Integer.MAX_VALUE;
        
        
        for (int c = 0; c < n; c++) {
            if (isPalindromeColumn(arr, c, n)) {
                minc = c;
                return minc + " C";
            }
        }
        
        
        return "-1";
    }

    public boolean isPalindromeRow(int[][] arr, int r, int n) {
        int j = n - 1;
        int k = 0;
        
        while (k < j) {
            if (arr[r][k] != arr[r][j]) {
                return false;
            }
            k++;
            j--;
        }
        return true;
    }

    public boolean isPalindromeColumn(int[][] arr, int c, int n) {
        int j = n - 1;
        int k = 0;
        
        while (k < j) {
            if (arr[k][c] != arr[j][c]) {
                return false;
            }
            k++;
            j--;
        }
        return true;
    }
}
