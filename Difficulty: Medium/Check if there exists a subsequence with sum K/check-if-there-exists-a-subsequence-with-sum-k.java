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
      int k = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
     
      Solution obj = new Solution();
      boolean ans = obj.checkSubsequenceSum(n,a,k);
      System.out.println(ans?"Yes":"No");
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
    // code here
    return checkExistance(arr,0,0,K);

  }
  
  public static boolean checkExistance(int[] arr,int i,int currSum, int targetSum){
      if(i== arr.length){
          return currSum==targetSum;
      }
      
      if(currSum > targetSum){
          return false;
      }
      
      //take
      if(checkExistance(arr,i+1,currSum+arr[i],targetSum)) return true;
      
      //not take
      if(checkExistance(arr,i+1,currSum,targetSum)) return true;
      
      
      
      return false;
  }
}
     