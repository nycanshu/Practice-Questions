//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String S){
        int i = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<>();

        for (int j = 0; j < S.length(); j++) {
            char ch = S.charAt(j);

            while (set.contains(ch)) {
                set.remove(S.charAt(i));
                i++;
            }

            set.add(ch);
            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;   
    }
}