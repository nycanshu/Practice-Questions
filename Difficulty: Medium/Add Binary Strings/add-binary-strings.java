//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a, b;
            a = sc.next();
            b = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String addBinary(String a, String b) {
        // code here
        int maxlen = Math.max(a.length(),b.length());
       char[] str =new char[maxlen+1];
       int k = maxlen;

       int carry = 0;
       int i=a.length()-1;
       int j=b.length()-1;
       while(i>=0 || j>=0|| carry>0){
           int sum=carry;
           if(i>=0){
               sum+=a.charAt(i--)-'0';
           }
           if(j>=0){
               sum+=b.charAt(j--)-'0';
           }
          str[k--] = (char) ((sum % 2) + '0');
          carry = sum/2;
       }
       String res = new String(str,k+1,maxlen-k);
       String res1 = res.replaceFirst("^0+", "");
       return res1.isEmpty()?"0":res1;
    }
}