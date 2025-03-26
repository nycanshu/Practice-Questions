//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            String line = sc.nextLine();
            String[] dictionary = line.split(" ");

            Solution obj = new Solution();
            if (obj.wordBreak(s, dictionary)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public boolean wordBreak(String s, String[] dictionary) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(dictionary)); // O(M) storage
        int n = s.length();
        boolean[] dp = new boolean[n + 1]; // DP array
        dp[0] = true; // Base case: empty string can be formed

        // Store only the valid indices using a Deque (Sliding Window Optimization)
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0); 

        for (int i = 1; i <= n; i++) {
            while (!deque.isEmpty() && i - deque.peekFirst() > 100) {
                deque.pollFirst(); // Remove indices that are too far (speed optimization)
            }

            for (int j : deque) {
                if (wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    deque.add(i); // Add this valid split index
                    break; // Stop further checking if found
                }
            }
        }

        return dp[n]; // Can we form the full string?
    }
}