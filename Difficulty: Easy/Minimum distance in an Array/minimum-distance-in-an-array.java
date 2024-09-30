//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = Integer.parseInt(str[i]);
            String[] xy = br.readLine().trim().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            Solution g = new Solution();
            System.out.println(g.minDist(a, n, x, y));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int minDist(int a[], int n, int x, int y) {
        int minDistance = Integer.MAX_VALUE; // Initialize with a large value
        int lastX = -1, lastY = -1;

        for (int i = 0; i < n; i++) {
            if (a[i] == x) {
                lastX = i;
            }
            if (a[i] == y) {
                lastY = i;
            }

            // If both x and y have been found at least once
            if (lastX != -1 && lastY != -1) {
                int distance = Math.abs(lastX - lastY);
                minDistance = Math.min(minDistance, distance);
            }
        }

        // If either x or y wasn't found in the array, return -1
        if (lastX == -1 || lastY == -1) {
            return -1;
        }
        
        return minDistance;

    }
}