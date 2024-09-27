//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    
    public int getMinCost(int[] arr, int k, int index, int[] dp) {
        if(index == arr.length-1) {
            return 0;
        }
        if(dp[index] != -1) {
            return dp[index];
        }
        
        int mini = Integer.MAX_VALUE;
        
        for(int i=1;i<=k && (index + i < arr.length);i++) {
            int cost = Math.abs(arr[index + i] - arr[index]) + getMinCost(arr, k, index + i, dp);
            
            mini = Math.min(mini, cost);
        }
        dp[index] = mini;
        
        return mini;
    }
    
    
    public int minimizeCost(int k, int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        
        for(int i=0;i<n;i++) {
            dp[i] = -1;
        }
        
        return getMinCost(arr, k, 0, dp);
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minimizeCost(k, arr);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends