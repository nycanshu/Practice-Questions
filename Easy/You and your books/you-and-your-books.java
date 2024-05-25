//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T > 0) {
            int N = sc.nextInt();
            int k = sc.nextInt();
            int ar[] = new int[N];
            //	int count = 0;
            for (int i = 0; i < N; i++) ar[i] = sc.nextInt();

            System.out.println(new Solution().max_Books(ar, N, k));
            T--;
        }
    }
}
// } Driver Code Ends



class Solution {

    // Method to calculate the maximum number of books that can be collected
    long max_Books(int arr[], int n, int k) {
        
        // Initialize variables to keep track of the maximum number of books collected
        // and the current count of books in the valid sequence of stacks.
        long maxBooksCollected = 0;
        long currentCount = 0;

        // Iterate through each stack of books.
        for(int i = 0; i < n; i++) {
            // Check if the height of the current stack is less than or equal to k.
            if(arr[i] <= k) {
                // If true, add the height of the current stack to the current count.
                currentCount += arr[i];
                // Update the maximum number of books collected if the current count exceeds the previous maximum.
                maxBooksCollected = Math.max(currentCount, maxBooksCollected);
            } else {
                // If false, reset the current count as the sequence is invalid.
                currentCount = 0;
            }
        }

        // Return the maximum number of books collected.
        return maxBooksCollected;
    }
}