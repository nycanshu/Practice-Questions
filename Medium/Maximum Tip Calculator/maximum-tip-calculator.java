//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int x;
            x = Integer.parseInt(br.readLine());

            int y;
            y = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            int[] brr = IntArray.input(br, n);

            Solution obj = new Solution();
            long res = obj.maxTip(n, x, y, arr, brr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
       
        if(n==1){
            if(arr[0]>brr[0])return (long)arr[0];
            return (long)brr[0];
        }
        
        int D[][] = new int[n][2];
        
        for(int i=0;i<n;i++){
            D[i][0] = Math.abs(arr[i]-brr[i]);
            D[i][1] = i;
        }
        Arrays.sort(D,Comparator.comparingDouble(o->(o[0]))); 
        
        long ans = 0l;
        for(int i=n-1;i>=0;i--){
            
            int idx  = D[i][1];
            
            if(x==0){
                ans+=(long)brr[idx];
            }
            else if(y==0){
                ans+=(long)arr[idx];
            }
            
            else if(arr[idx]>=brr[idx]){
                 ans+=(long)arr[idx];
                 x--;
            }
            else if(arr[idx]<brr[idx]){
                 ans+=(long)brr[idx];
                 y--;
            }
        }
        return ans;
    }
}
