//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            long N;
            N = Long.parseLong(br.readLine().trim());

            Solution obj = new Solution();
            int res = obj.countGoodNumbers(N);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    static final int mod = 1000000007;
    
    public static int countGoodNumbers(long N) {
        long even = (N + 1) / 2; // Number of even index positions in N
        long odd = N / 2; // Number of odd index positions in N
        
        long chanceOfEven = pow(5, even) % mod;
        long chanceOfOdd = pow(4, odd) % mod;
        
        return (int)((chanceOfEven * chanceOfOdd) % mod);
    }
    
    private static long pow(long x, long n) {
        if (n == 0) return 1;
        
        long temp = pow(x, n / 2) % mod;
        temp = (temp * temp) % mod;
        
        if (n % 2 == 0) {
            return temp;
        } else {
            return (x * temp) % mod;
        }
    }
}
