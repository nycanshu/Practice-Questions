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
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestPalindrome(String S){
        // code here
        int n = S.length();
        //int maxLength = Integer.MIN_VALUE;
        if(n==0) return "";
        
        String longest = "";
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                
                String subs = S.substring(i,j);
                
                if(isPalindrom(subs)){
                    if(subs.length()>longest.length()){
                        longest=subs;
                    }
                }
            }
        }
        return longest;
        
    }
    
    
    
    
    
    
    static boolean isPalindrom (String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}