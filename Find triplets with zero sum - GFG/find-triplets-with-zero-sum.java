//{ Driver Code Starts
import java.util.*;
class Triplets{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Solution g=new Solution();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
			
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
	public boolean findTriplets(int arr[] , int n)
    {
        //add code here.
        boolean res = false;
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            //using 2 pointer method to calculate sum.
            int left = i+1;
            int right = n-1;
            while(left<right){
                int sum = arr[i]+arr[left]+arr[right];
                if(sum==0){
                    res = true;
                    return res;
                }
                else if(sum<0){
                    left++;
                }else{
                    right--;
                }
            }
            
        }
        return res;
    }
}