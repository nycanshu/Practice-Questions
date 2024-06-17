//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            int ans = ob.rectanglesInCircle(N);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int rectanglesInCircle(int R) {
    int count = 0;
    for (int length = 1; ; length++) {
        for (int breadth = 1; ; breadth++) {
            if (length * length + breadth * breadth > 4 * R * R) {
                break;
            }
            count++;
        }
        if (length * length > 4 * R * R) {
            break;
        }
    }
    return count;
}
};