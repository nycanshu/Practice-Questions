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
            long N=sc.nextLong();
			
            Solution ob = new Solution();
            ArrayList<Long> ans = ob.factorialNumbers(N);
            for(long num : ans){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Long> factorialNumbers(long N){
        // code here
        ArrayList<Long> ans = new ArrayList<>();
        
        for(long i=1;i<=N;i++){
            
            if(factorial(i)<=N){
                ans.add(factorial(i));
                
            }else{
                break;
            }
           
        }
        return ans;
    }
    
    static long factorial(long N){
        if(N==0 || N==1){
            return 1;
            
        }
        
        return factorial(N-1)*N;
        
    }
}