//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());

            ArrayList<Integer> ans = new Solution().countDistinct(arr, k);

            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            t--;
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
        
        if (n < k) return result;
        
        ArrayDeque<Integer> window = new ArrayDeque<>();
        Set<Integer> distinct = new HashSet<>();
        
        // Process first window
        for (int i = 0; i < k; i++) {
            window.add(arr[i]);
            distinct.add(arr[i]);
        }
        
        result.add(distinct.size());
        
        // Process remaining windows
        for (int i = k; i < n; i++) {
            // Remove first element
            int removed = window.removeFirst();
            if (!window.contains(removed)) {
                distinct.remove(removed);
            }
            
            // Add new element
            window.add(arr[i]);
            distinct.add(arr[i]);
            
            result.add(distinct.size());
        }
        
        return result;
    }
}
