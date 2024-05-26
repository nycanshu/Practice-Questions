//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] a = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.longestSubseq(n, a);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution{
    static int Helper(int n,int arr[],int curr,int prev,int dp[][]){
        if(curr >= n){
            return 0;
        }
        if(dp[curr][prev+1] != -1){
            return dp[curr][prev+1];
        }
        int take = 0;
        if((prev == -1) || (Math.abs(arr[curr] - arr[prev]) == 1)){
            take = 1 + Helper(n,arr,curr+1,curr,dp);
        }
        int nottake = Helper(n,arr,curr+1,prev,dp);
        return dp[curr][prev+1] = Math.max(take,nottake);
    }
    static int longestSubseq(int N, int A[])
    {
        // code here
       int dp[][] = new int[N][N+1];
       for(int i = 0; i <= N-1; i++){
           for(int j = 0; j <= N;j++){
               dp[i][j] = -1;
           }
       }
       return Helper(N,A,0,-1,dp);
    }
}
