//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            
            if(obj.leftRight(a, n)==true)
            System.out.println(1);
            else
            System.out.println(0);
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {

     // Function to check Left or Right Positioned
    // Array.
    // arr[] is array of n elements
    // visited[] is boolean array of size n
    public static boolean leftRight(int arr[],int n)
    {
        // Your code goes here
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int x : arr){
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }
        
        for(int i=0; i<n; i++){
            if(hm.getOrDefault(i, 0) > 0){
                hm.put(i, hm.get(i) - 1);
            }
            else if(hm.getOrDefault(n-1-i, 0) > 0){
                hm.put(n-1-i, hm.get(n-1-i) - 1);
            }
            else{
                return false;
            }
        }
        
        return true;
        
    }
}
