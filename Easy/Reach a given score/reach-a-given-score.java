//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        while(t > 0)
        {
            int n = in.nextInt();
            Geeks obj = new Geeks();
            System.out.println(obj.count(n));
            t--;
        }
    }
}
// } Driver Code Ends


// Complete this function!

class Geeks {
    public long count(int n) {
        int coins[] = {3,5,10};
        long dp[] = new long[n+1];
        dp[0] = 1;
        for(int i=0;i<coins.length;i++)
            for(int j=coins[i];j<=n;j++)
                dp[j] = dp[j] + dp[j-coins[i]];
        return dp[n];
    }
}