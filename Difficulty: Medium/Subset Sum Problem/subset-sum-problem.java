//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n=arr.length;
        Boolean dp[][]=new Boolean[n][sum+1];
        return rec(n-1,arr,sum,dp);
    }
    private static Boolean rec(int id,int arr[],int sum,Boolean dp[][]){
        if(sum==0) return true;
        if(id<0 || sum<0) return false;
        if(dp[id][sum]!=null) return dp[id][sum];
        Boolean p=rec(id-1,arr,sum-arr[id],dp);
        Boolean np=rec(id-1,arr,sum,dp);
        return dp[id][sum]=p || np;
    }
}