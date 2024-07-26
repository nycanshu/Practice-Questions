//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      Solution obj = new Solution();
      List<String> ans = obj.generateBinaryStrings(n);
      for(String s : ans) System.out.print(s+" ");
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static List<String> generateBinaryStrings(int n) {
    List<String> result = new ArrayList<>();
    
    for(int i=0;i<Math.pow(2,n);i++){
        StringBuffer sb = new StringBuffer(Integer.toBinaryString(i));
        
        while(sb.length()<n){
            sb.insert(0,"0");
        }
        
        if(!hasConsecutiveOnes(sb.toString())){
            result.add(sb.toString());
        }
    }
    return result;
  }
  
  public static boolean hasConsecutiveOnes(String s){
      for(int i=0;i<s.length()-1;i++){
          if(s.charAt(i)=='1' && s.charAt(i+1)=='1'){
              return true;
          }
      }
      return false;
  }
}