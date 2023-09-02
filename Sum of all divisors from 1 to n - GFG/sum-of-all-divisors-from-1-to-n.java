//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			
            
            Solution ob = new Solution();
            long ans  = ob.sumOfDivisors(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long sumOfDivisors(int N){
        // code here
        
        /**SUM OF DIVISOR FROM 1 TO N
            for any no. N = 1 appears  - N/1 times
                            2 appears - N/2 times 
                            m appears - N/m times 
                                                 and so on 

                            eg for N=3
                            1 appears = 3/1=3 times
                            2 appears = 3/2= 1 time
                            3 appears = 3/3= 1 time

                            as
                            f(1)=1
                            f(2)=1+2
                            f(3)=1+3

        since we now know frequency now only multiply with the digits and then sum       
        so for sum we do loop 1 to N and sum = sum + i * ( N /  i ) **/
        
        long sum=0L;
        
        for(int i=1;i<=N;i++){
            sum = sum + i*(N/i);
        }
        
        return sum;
    }
}