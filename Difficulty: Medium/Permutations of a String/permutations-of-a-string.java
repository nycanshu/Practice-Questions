//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPermutation(String s) {
        ArrayList<String> result = new ArrayList<>();
        permute(s.toCharArray(), 0, result);
        return result;
    }

    private void permute(char[] arr, int index, List<String> result) {
        if (index == arr.length - 1) {
            result.add(new String(arr)); // Add the permutation to the result list
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (!shouldSwap(arr, index, i)) {
                continue; // Skip duplicates to avoid redundant permutations
            }
            swap(arr, index, i); // Swap characters
            permute(arr, index + 1, result); // Recurse for the next index
            swap(arr, index, i); // Backtrack (restore the original array)
        }
    }

    private boolean shouldSwap(char[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            if (arr[i] == arr[end]) {
                return false; // Skip if the character has already been processed
            }
        }
        return true;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}