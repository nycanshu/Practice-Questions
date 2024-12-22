//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }

            int x = sc.nextInt();

            if (new Solution().matSearch(mat, x))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    static boolean find(int arr[], int k){
        int n=arr.length;
        int l=0;
        int r=n-1;
        
        while(l<=r){
            int mid=(l+r)>>1;
            if(arr[mid]==k){
                return true;
            }else if(arr[mid]>k){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        
        return false;
    }
    
    
    
    public static boolean matSearch(int arr[][], int x) {
        int n=arr.length;
        
        if(n==1){
            return find(arr[0], x);
        }
        
        
        for(int i=0;i<n;i++){
             if(arr[i][0]<=x && arr[i][arr[0].length-1]>=x){
                if(find(arr[i], x))return true;
            }
        }
        
        return false;
    }
}