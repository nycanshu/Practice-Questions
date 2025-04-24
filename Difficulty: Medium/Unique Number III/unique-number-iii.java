//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSingle(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSingle(int[] arr) {
        // code here
        int ones = 0, twos = 0;
        
        for (int val : arr) {
            // Add val to 'ones' if it appears for the first time
            ones = (ones ^ val) & ~twos;
            // Add val to 'twos' if it appears for the second time
            twos = (twos ^ val) & ~ones;
        }
        
        // The 'ones' variable will now hold the unique element
        return ones;
    }
}