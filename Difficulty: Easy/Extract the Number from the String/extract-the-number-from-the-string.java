//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long ExtractNumber(String sentence) {
        // code here
        String[] words = sentence.split(" ");
        Long max  = Long.MIN_VALUE;
        
        for(String s : words){
            if( !s.isEmpty() && isNumber(s) && !s.contains("9")){
                Long value = Long.parseLong(s);
                if(value > max){
                    max = value;
                }
            }
        }
        return max == Long.MIN_VALUE ? -1 : max;
    }
    
    static boolean isNumber(String s){
        for(char c : s.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
}