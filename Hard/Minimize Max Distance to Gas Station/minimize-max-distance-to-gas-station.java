//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            Solution obj = new Solution();
            double ans = obj.findSmallestMaxDist(a, k);
            System.out.printf("%.2f", ans);
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    /**
     * Finds the smallest possible maximum distance between adjacent gas stations
     * after adding k additional stations.
     *
     * @param stations An array representing the positions of existing gas stations.
     * @param k The number of additional gas stations to add.
     * @return The smallest possible value of the maximum distance between adjacent gas stations.
     */
    static double findSmallestMaxDist(int[] stations, int k) {
        int n = stations.length;
        double left = 0, right = getMaxDistance(stations);

        // Binary search for the smallest possible maximum distance
        while (right - left > 1e-6) { // Precision of 1e-6 for the required two decimal places
            double mid = (left + right) / 2;
            if (canPlaceStations(stations, n, k, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return Math.round(right * 100.0) / 100.0; // Return result rounded to 2 decimal places
    }

    /**
     * Determines if it is possible to place the additional k gas stations such that
     * the maximum distance between any two adjacent gas stations is less than or equal to mid.
     *
     * @param stations An array representing the positions of existing gas stations.
     * @param n The number of existing gas stations.
     * @param k The number of additional gas stations to add.
     * @param mid The proposed maximum distance to test.
     * @return True if it is possible to place the stations under the given condition, otherwise false.
     */
    static boolean canPlaceStations(int[] stations, int n, int k, double mid) {
        int requiredStations = 0;

        for (int i = 1; i < n; i++) {
            double distance = stations[i] - stations[i - 1];
            requiredStations += Math.ceil(distance / mid) - 1; // Calculate the number of stations needed
        }

        return requiredStations <= k;
    }

    /**
     * Calculates the maximum distance between any two adjacent gas stations in the given array.
     *
     * @param stations An array representing the positions of existing gas stations.
     * @return The maximum distance between any two adjacent gas stations.
     */
    static double getMaxDistance(int[] stations) {
        double maxDistance = 0.0;

        for (int i = 1; i < stations.length; i++) {
            maxDistance = Math.max(maxDistance, stations[i] - stations[i - 1]);
        }

        return maxDistance;
    }
}