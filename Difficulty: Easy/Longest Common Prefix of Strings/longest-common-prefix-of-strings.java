//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            String ans = ob.longestCommonPrefix(arr);

            if (ans.isEmpty()) {
                System.out.print("\"\"");
            } else {
                System.out.print(ans);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
        String pref = arr[0];
        int n = arr.length;
        
        for(int i=1;i<n;i++){
            
            while(arr[i].indexOf(pref) != 0 ){
                pref = pref.substring(0,pref.length()-1);
                
                
                if(pref.isEmpty()){
                    return "";
                }
            }
            
            
            
        }
        return pref;
    }
}