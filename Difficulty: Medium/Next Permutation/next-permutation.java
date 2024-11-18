//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // Number of test cases
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int N = arr.length;
            Solution ob = new Solution();
            ob.nextPermutation(arr); // Generate the next permutation
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < N; i++) {
                out.append(arr[i] + " "); // Corrected: use arr[i] instead of arr.get(i)
            }
            System.out.println(out.toString().trim()); // Print the output
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void nextPermutation(int[] arr) {
        // Find the first pair from the right where arr[i] < arr[i+1]
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        
        // If no such pair found, reverse the entire array
        if (i < 0) {
            reverse(arr, 0, arr.length - 1);
            return;
        }
        
        // Find the smallest number in the right subarray 
        // that is greater than arr[i]
        int j = arr.length - 1;
        while (j > i && arr[j] <= arr[i]) {
            j--;
        }
        
        // Swap arr[i] and arr[j]
        swap(arr, i, j);
        
        // Reverse the subarray to the right of i
        reverse(arr, i + 1, arr.length - 1);
    }
    
    // Helper method to reverse a portion of the array
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
    
    // Helper method to swap two elements
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}