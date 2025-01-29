//{ Driver Code Starts
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            double b = sc.nextDouble();
            int e = sc.nextInt();
            Solution ob = new Solution();
            System.out.printf("%.5f\n", ob.power(b, e));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends
// User function Template for Java
class Solution {
    double power(double b, int e) {
        // code here
        return rec(b, (long) e);
        
        
    }
    
    private double rec(double x, long e){
        if( e == 0) return 1;
        
        if(e < 0 ){
            return 1.0 / rec(x, -e);
        }
        
        if(e %2 == 1){
            return x * rec(x*x, (e-1)/2);
        }else{
            return rec(x*x, e/2);
        }
        
    }
}

//{ Driver Code Starts.
// } Driver Code Ends