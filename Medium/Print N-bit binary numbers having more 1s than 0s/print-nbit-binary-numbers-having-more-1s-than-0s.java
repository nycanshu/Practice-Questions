//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<String> NBitBinary(int N) {
        ArrayList<String> result = new ArrayList<>();
        backtrack("", 0, 0, N, result);
        return result;
    }
    static void backtrack(String s, int ones, int zeros, int n, ArrayList<String> result) {
        if (s.length() == n) {
            result.add(s);
            return;
        }
        if (s.length() < n) backtrack(s + '1', ones + 1, zeros, n, result);
        if (ones > zeros) backtrack(s + '0', ones, zeros + 1, n, result);
    }
}