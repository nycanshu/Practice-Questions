//{ Driver Code Starts
import java.util.*;

class ExtraElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n - 1];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n - 1; i++) b[i] = sc.nextInt();
            Solution g = new Solution();
            System.out.println(g.findExtra(n, a, b));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class Solution {
    public int findExtra(int n, int a[], int b[]) {
        // add code here.
        if(n==1){
            return 0;
        }
        if(a[n-1] != b[n-2]){
            return n-1;
        }
        int si = 0;
        int ei = n-1;
        while(si<=ei){
            int mid = si + (ei-si)/2;
            if(a[mid]==b[mid]){
                si = mid +1;
            }else{
                ei = mid -1;
            }
        }
        return si;
    }
}