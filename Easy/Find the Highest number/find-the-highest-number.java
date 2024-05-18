//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            int n = Integer.parseInt(s);
            String S = br.readLine();
            String[] s1 = S.split(" ");
            List<Integer> a = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                a.add(Integer.parseInt(s1[i]));
            }
            Solution ob = new Solution();
            int ans = ob.findPeakElement(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int findPeakElement(List<Integer> a) {
        // Initialize two pointers: 'left' starting at the beginning of the array
        // and 'right' starting at the end of the array.
        int left = 0;
        int right = a.size() - 1;
        
        // Perform a binary search.
        while (left < right) {
            // Find the middle index to divide the array into two halves.
            int mid = left + (right - left) / 2;
            
            // Compare the middle element with its next element to decide which half to keep.
            // If the middle element is greater than the next element, the peak is in the left half (including mid).
            if (a.get(mid) > a.get(mid + 1)) {
                right = mid; // Move the 'right' pointer to 'mid'.
            } else {
                // If the middle element is less than the next element, the peak is in the right half.
                left = mid + 1; // Move the 'left' pointer to 'mid + 1'.
            }
        }
        
        // When the pointers converge, 'left' will be pointing to the peak element.
        return a.get(left);
    }
}