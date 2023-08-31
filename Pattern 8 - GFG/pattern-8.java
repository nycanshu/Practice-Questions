//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution obj=new Solution();
            obj.printTriangle(n);
        }
    }
}
// } Driver Code Ends


class Solution {

    void printTriangle(int n) {
        // code here
        for(int line=0;line<n;line++){
            
            //below code for half triangle
            //code to print space
            for(int val=0;val<line;val++){
                System.out.print(" ");
            }
            
            //code to print star
            
            for(int val=0;val<2*n-(2*line+1);val++){
                System.out.print("*");
            }
            //code to print space
            for(int val=0;val<line;val++){
                System.out.print(" ");
            }
       
            System.out.println();
        }
    }
}