//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        int t = ob.nextInt();
        while (t-- > 0) {
            long n = ob.nextLong();
            Solution ab = new Solution();
            long k = ab.findNth(n);
            System.out.println(k);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
  
    long findNth(long n) {
        // code here
        long result=0;
        int mod=1;
        while (n>0)
        {
            result +=(n%9)*mod;
            n /= 9;
            mod *=10;
            
        }
        return result;
    }
}