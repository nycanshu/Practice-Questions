//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            Long A = Long.parseLong(S[0]);
            Long B = Long.parseLong(S[1]);

            Solution ob = new Solution();
            Long[] ptr = ob.lcmAndGcd(A,B);
            
            System.out.print(ptr[0]);
            System.out.print(" ");
            System.out.println(ptr[1]);
        }
    }
}
// } Driver Code Ends


class Solution {
    static Long[] lcmAndGcd(Long A , Long B) {
        // code here
        
        Long[] ans = new Long[2];
        
        ans[0] = lcmof(A,B);
        ans[1] = gcd(A,B);
        
        return ans;
    }
    
    //hcf is also known as GCD
    

    
    static Long gcd(Long P, Long Q){
        
        if(Q==0){
            return P;
        }
        else{
            return gcd(Q,P%Q);
        }
    }
    
    //we can use formulla a*b = hcfof(a,b)*lcmof(a,b) to calculate lcm from hcf(gcd)
    
    static Long lcmof(Long p, Long q){
        return p*q/gcd(p,q);
    }
}