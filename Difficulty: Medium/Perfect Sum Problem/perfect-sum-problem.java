//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
int mod = (int)(1e9 + 7);
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	int [][]dp =new int [n][sum+1];
	for(int i=0;i<n;i++)Arrays.fill(dp[i],-1);
	    return f(arr,n-1,sum,dp);
	} 
	public int f(int arr[],int idx, int sum,int [][]dp ){
	    //if(sum==0) return 1;
	    //if(sum<0) return 0;
	    /*if(idx==0){
	        if(arr[0]==sum) return 1; else return 0;}
	    */
	    if(idx<0){
	        if(sum==0) return 1;
	        else return 0;
	    }
	    if(dp[idx][sum]!=-1) return dp[idx][sum];
	    int nottake =f(arr,idx-1,sum,dp);
	    int take =0;
	    if(arr[idx]<=sum)
	    take =f(arr,idx-1,sum-arr[idx],dp);
	    return dp[idx][sum]=(nottake+take)%mod;
	}
}