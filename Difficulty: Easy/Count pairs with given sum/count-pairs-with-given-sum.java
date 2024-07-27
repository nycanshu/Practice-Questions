//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            int k = Integer.parseInt(read.readLine().trim());
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            Solution obj = new Solution();
            int ans = obj.getPairsCount(nums, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int getPairsCount(int[] arr, int sum) {
        // code here
        // Create a HashMap to store the frequency of each number
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        
        int count = 0; // Count of pairs that add up to k
        
        // Iterate over the array
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int diff = sum - num; // Calculate the difference between k and the current number
            
            // If the difference is already present in the HashMap, increment the count
            if (freqMap.containsKey(diff)) {
                count += freqMap.get(diff);
            }
            
            // Update the frequency of the current number in the HashMap
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        return count; // Return the count of pairs that add up to k
    }
}
