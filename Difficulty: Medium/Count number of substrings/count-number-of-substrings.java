//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
 
    long countSubstring(String S, int K) {
        int n = S.length();
        int[] freq = new int[26];
        int uc = 0;
        long count = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (freq[S.charAt(right) - 'a'] == 0) {
                uc++;
            }
            freq[S.charAt(right) - 'a']++;
            
            while (uc > K) {
                freq[S.charAt(left) - 'a']--;
                if (freq[S.charAt(left) - 'a'] == 0) {
                    uc--;
                }
                left++;
            }
            count += right - left + 1;
        }
        
        return count;
    }
    
    
    long substrCount(String S, int K) {
        if (S == null || K <= 0) {
            return 0;
        }
        
        return countSubstring(S, K) - countSubstring(S, K - 1);
    }
}