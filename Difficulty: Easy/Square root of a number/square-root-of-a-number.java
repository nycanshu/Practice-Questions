//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends




/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution
{
     long floorSqrt(long x)
	 {
	    if(x==1) return 1;
	    
	    long low =1;
	    long high =x/2;
	    long mid =0;
	    while(low<=high){
	        mid = high+(low-high)/2;
	        if(mid*mid == x) return mid;
	        if(mid*mid>x) high = mid-1;
	        else low = mid+1;
	    }
	    return (mid*mid>x)?mid-1:mid;
	 }
}
