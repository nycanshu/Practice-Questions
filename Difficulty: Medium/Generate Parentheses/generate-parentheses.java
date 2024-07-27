//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        List<String> ans = new ArrayList<>();
        generate("",0,0,n,ans);
        return ans;
    }
    public static void generate(String s,int open, int close,int n,List<String> ans){
        if(s.length()==2*n){
            if(isValid(s)){
                ans.add(s);
                return;
            }
        }
        
        if(open < n){
            generate(s+"(",open+1,close,n,ans);
        }
        if(close < n){
            generate(s+")",open,close+1,n,ans);
        }
    }
    
    public static boolean isValid(String s){
        int count=0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                count++;
            }else{
                count--;
                if(count<0) return false;
            }
        }
        return count==0;
    }
}