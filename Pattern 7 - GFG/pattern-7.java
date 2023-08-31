//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            obj.printTriangle(n);
        }
    }
}
// } Driver Code Ends


class Solution {

    void printTriangle(int n) {
        // code here
        for(int line=0;line<n;line++){
           
           //code to print space
            for(int val=0;val<n-line-1;val++){
                System.out.print(" ");
            }
            
            //loop to print stars
            for(int val=0;val<(2*line)+1;val++){
                System.out.print("*");
            }
            
            //repeat the same loop for the spaces
            for(int val=0;val<n-line-1;val++){
                System.out.print(" ");
            }
            
            System.out.println();
            
        }
    }
}