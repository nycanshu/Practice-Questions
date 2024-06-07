//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String x = read.readLine();
            String y = read.readLine();
            Solution ob = new Solution();
            String result = ob.findSum(x, y);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String findSum(String X, String Y) {
        // code here
        StringBuilder x = new StringBuilder(X);
        StringBuilder y = new StringBuilder(Y);
        StringBuilder ans = new StringBuilder();
        
        int carry = 0,sum=0;
        
        while(x.length()>0 || y.length()>0){
            int first = x.length()!=0 ? x.charAt(x.length()-1)-'0' : 0;
            int second = y.length()!=0 ? y.charAt(y.length()-1)-'0' : 0;
            
            sum = first+second+carry;
            
            if(sum>9){
                sum -= 10;
                carry = 1;
            }else{
                carry = 0;
            }
            
            //insert the value to 0th index
            ans.insert(0,sum);
            
            //reduce the length to remove last value
            if(x.length()>0){
                x.setLength(x.length()-1);
            }
            if(y.length()>0){
                y.setLength(y.length()-1);
            }
        }
        
        if(carry==1){
            ans.insert(0,1);
        }
        
        for(int i=0;i<ans.length();i++){
                if(ans.charAt(i)!= '0'){
                    return ans.substring(i);
                }
            }
        
        return "0";
    }
}