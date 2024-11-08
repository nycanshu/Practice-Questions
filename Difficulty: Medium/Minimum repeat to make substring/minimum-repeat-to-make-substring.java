//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A = read.readLine();
            String B = read.readLine();

            Solution ob = new Solution();
            out.println(ob.minRepeats(A, B));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minRepeats(String A, String B) {
        int minRepeats = (int) Math.ceil((double) B.length() / A.length());
        StringBuilder repeatedA = new StringBuilder(A.repeat(minRepeats));

        // Check if B is in the current repeated string using KMP
        if (kmpSearch(B, repeatedA.toString())) {
            return minRepeats;
        }
        
        // Check if adding one more repetition of A contains B
        repeatedA.append(A);
        if (kmpSearch(B, repeatedA.toString())) {
            return minRepeats + 1;
        }
        
        // B was not found in the repeated strings
        return -1;
    }
    
    // KMP search function to check if pattern exists in the text
    private static boolean kmpSearch(String pattern, String text) {
        int[] lps = computeLPSArray(pattern);
        int i = 0;  // index for text
        int j = 0;  // index for pattern
        
        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == pattern.length()) {
                return true;  // Found pattern
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }
    
    // Helper function to compute the Longest Prefix Suffix (LPS) array for KMP
    private static int[] computeLPSArray(String pattern) {
        int len = 0;
        int i = 1;
        int[] lps = new int[pattern.length()];
        lps[0] = 0;
        
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
