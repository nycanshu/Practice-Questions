//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;


// } Driver Code Ends
class Solution {
public int maxDistance(int[] arr) {
    // Map to store the first occurrence of each element
    HashMap<Integer, Integer> hm = new HashMap<>();
    int max = 0; // Store the maximum distance

    for (int i = 0; i < arr.length; i++) {
        // If the element is already present in the map, calculate the distance
        if (hm.containsKey(arr[i])) {
            int firstIndex = hm.get(arr[i]); // First occurrence
            int distance = i - firstIndex;  // Calculate distance
            max = Math.max(max, distance);  // Update max distance
        } else {
            // Store the first occurrence of the element
            hm.put(arr[i], i);
        }
    }

    return max; // Return the maximum distance
}

}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxDistance(arr));
        }
        sc.close();
    }
}
// } Driver Code Ends