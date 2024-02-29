//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}

// } Driver Code Ends


class Solution{
    static int minJumps(int[] arr){
        // your code here
        
        int totalJump =0;
        int destination = arr.length-1;
        int coverage =0;
        int lastJumpIdx =0;
        
        if(arr.length ==1) 
        return 0; 
        // if(arr[0]==0){
        //     return -1;
        // }
        
        for(int i=0;i<arr.length;i++) {
            coverage = Math.max(coverage,i+arr[i]);
            
            if(i==lastJumpIdx) {
                lastJumpIdx = coverage;
                totalJump++;
                
                if(coverage>=destination) {
                    return totalJump;
                }
            }
        }
        return -1;
    }
}

