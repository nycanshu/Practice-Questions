//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();

            Solution ob = new Solution();
            ob.printDiamond(n);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    void printDiamond(int n) {
        // Your code here
        for(int line=0;line<n;line++){
            
            //below code for half triangle
            //code to print space
            for(int val=0;val<n-line-1;val++){
                System.out.print(" ");
            }
            
            //code to print star
            
            for(int val=0;val<2*line+1;val++){
                if(val%2!=0) System.out.print(" ");
                else System.out.print("*");
            }
            //code to print space
            for(int val=0;val<n-line-1;val++){
                System.out.print(" ");
            }
            
            System.out.println();
        }
       //code to print inverted triangle
       for(int line=0;line<n;line++){
           
           //code to print space
            for(int val=0;val<line;val++){
                System.out.print(" ");
            }
            
            //code to print star
            
            for(int val=0;val<2*n-(2*line+1);val++){
                if(val%2==0) System.out.print("*");
                else System.out.print(" ");
                
            }
            //code to print space
            for(int val=0;val<line;val++){
                System.out.print(" ");
            }
       
            System.out.println();
        }
        
    }
    
}

