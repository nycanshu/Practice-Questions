//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
         // add your code here
        int N = arr.length;
	   Arrays.sort(arr);
	   int start = 0;
	   int end =1 ;
	   
	   int currlength = 0;
	   int longestlength = Integer.MIN_VALUE;
	   
	   if(N==1) return 1;
	   
	   while(end<N){
	       
	       if(arr[start] == arr[end]){
	           //skip this count;
	           start++;
	           end++;
	           
	       }
	       else if(arr[end] - arr[start] == 1){
	           //only count this conditon.
	           currlength++;
	           start++;
	           end++;
	           
	       }else{
	           //reset the counter 
	           currlength=0;
	           start++;
	           end++;
	           
	       }
	       longestlength = Math.max(longestlength, currlength);
	   }
	   return longestlength+1;
    }
}