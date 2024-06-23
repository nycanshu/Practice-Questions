//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");

            long n = Long.parseLong(S[0]);
            long q = Long.parseLong(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.sumMatrix(n, q));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static long sumMatrix(long n, long q) {
        // Checking if q is out of possible value range in the matrix
        if (q < 2 || q > 2 * n) {
            return 0;
        }
        
        // Calculate the valid range of 'i'
        long start = Math.max(1, q - n);
        long end = Math.min(n, q - 1);
        
        // Calculate and return the count of valid cells
        return end - start + 1;
    }
}