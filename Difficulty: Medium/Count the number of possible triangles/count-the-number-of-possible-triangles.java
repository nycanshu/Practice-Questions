//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countTriangles(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        Arrays.sort(arr);
        int n=arr.length;
        int cnt=0;
        for(int i=2;i<n;i++){
             int j=0;
             int k=i-1;
             while(j < k){
                   int sum=arr[j]+arr[k];
                   if(sum > arr[i]){
                       cnt+=k-j;
                       k--;
                   }
                   else{
                       j++;
                   }
             }
        }
        
        return cnt;
    }
}

