//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            v = new Solution().modifyAndRearrangeArr(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static ArrayList<Integer> modifyAndRearrangeArr(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> modifiedList = new ArrayList<>();

        // Traverse the array
        for (int i = 0; i < n; i++) {
            // Check if the current and next elements are valid and equal
            if (i < n - 1 && arr[i] != 0 && arr[i] == arr[i + 1]) {
                // Double the current number and replace the next with 0
                modifiedList.add(arr[i] * 2);
                i++; // Skip the next element since it's already processed (set to 0)
            } else if (arr[i] != 0) {
                // Add valid numbers to the list
                modifiedList.add(arr[i]);
            }
        }

        // Count the number of zeros to add at the end
        int countZeroes = n - modifiedList.size();

        // Append the zeros to the modifiedList
        for (int i = 0; i < countZeroes; i++) {
            modifiedList.add(0);
        }

        return modifiedList;
    }
}
