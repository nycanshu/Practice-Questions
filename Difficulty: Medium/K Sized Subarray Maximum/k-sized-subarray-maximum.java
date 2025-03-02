//{ Driver Code Starts
// Initial template for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
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
            int k = Integer.parseInt(br.readLine());
            ArrayList<Integer> res = new Solution().maxOfSubarrays(arr, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// Custom Pair class to store value and index
class Pair {
    public int first, second;
    Pair(int f, int s) {
        first = f;
        second = s;
    }
}

// Comparator to sort pairs in descending order of value
class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2) {
        if (p1.first > p2.first) return -1;
        else if (p1.first < p2.first) return 1;
        else return 0;
    }
}

class Solution {
    public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        // Max heap to store pairs of (value, index)
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
        
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        
        // Insert the first k elements into the heap
        for (int i = 0; i < k; ++i) {
            pq.add(new Pair(arr[i], i));
        }
        
        // Max of the first window
        ans.add(pq.peek().first);
        
        // Slide the window through the array
        for (int i = k; i < n; ++i) {
            // Add the current element to the heap
            pq.add(new Pair(arr[i], i));
            
            // Remove elements that are outside the current window
            while (!pq.isEmpty() && pq.peek().second <= i - k) {
                pq.poll();
            }
            
            // The top of the heap is the max of the current window
            ans.add(pq.peek().first);
        }
        
        return ans;
    }
}