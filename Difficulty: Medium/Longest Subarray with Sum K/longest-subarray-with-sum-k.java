//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int k = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            int ans = ob.longestSubarray(nums, k); // Call the function and store result
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int longestSubarray(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int cur=0, ans=0, n=arr.length;
        for(int i=0;i<n;i++){
            cur+=arr[i];
            if(map.containsKey(cur-k)) ans=Math.max(ans,i-map.get(cur-k));
            if(!map.containsKey(cur))  map.put(cur,i);
        }
        return ans;
    }
}