//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.beautySum(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int beautySum(String s) {
        // code here
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];
            for (int j = i; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']++;
                sum += beauty(freq);
            }
        }
        return sum;
        
        
        
    }
    static int beauty(int[] freq) {
        int min_val = Integer.MAX_VALUE;
        int max_val = Integer.MIN_VALUE;
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                min_val = Math.min(min_val, freq[i]);
                max_val = Math.max(max_val, freq[i]);
            }
        }
        return (max_val - min_val);
    }
}
        
