//{ Driver Code Starts
// Initial Template for Java

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
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.lemonadeChange(n, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
 static boolean lemonadeChange(int N, int b[]) {
        int tota=0;
        int f=0;
        int ten=0;
        int two=0;
        for(int i=0;i<N;i++){
            if(i==0&&b[i]!=5){
                return false;
            }
            if(b[i]==5){
                tota+=5;
             f++;   
            }
            else if(b[i]==10){
               int k=b[i]-5;
               if(f>0){
                   ten++;
                   f--;
               }else{
                   return false;
               }
            }else{
          int k=b[i]-5;
           if(ten>0&&f>0){
               two++;
               ten--;
               f--;
           }else if(f>0&&5*f>=k){
               f-=3;
              two++;
           }else{
               return false;
           }
        
            }
       //   System.out.println(f+" "+b[i]);
            
        }
        return true;
        
    }
}

