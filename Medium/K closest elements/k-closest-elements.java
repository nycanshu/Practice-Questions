//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);

            int[] ans = new Solution().printKClosest(arr, n, k, x);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int[] printKClosest(int[] arr, int n, int k, int x) {
       // code here

       int res[] = new int[k];
       if (arr.length==1){
           res[0] = arr[0];
       }else if (arr[0]>x){
           for (int i = 0 ; i< k;i++){
               res[i] = arr[i];
           }
       }else {

           int crossOverPoint = crossOverPoint(arr,x);
           if (crossOverPoint == arr[n-1]){
               int count = 0;
               for (int i =n-1;i>=0 && count<k ; i-- ){
                   res[count] = arr[i];
                   count++;
               }
           }else {

               int count = 0;
               if (crossOverPoint == 0 && ((Math.abs(arr[0]-x) == Math.abs(arr[1]-x)) ||
                       (Math.abs(arr[crossOverPoint+1]-x)< Math.abs(arr[crossOverPoint]-x)))){
                   crossOverPoint = 1;
               }
               if (Math.abs(arr[crossOverPoint]-x) !=0){

                   res[count] = arr[crossOverPoint];
                   count++;

               }
               int i = crossOverPoint-1;
               int j = crossOverPoint+1;

               while (i>=0 && j<n && count<k){
                   int prevDiff = Math.abs(arr[i]-x);
                   int nextDiff = Math.abs(arr[j]-x);
                   if (prevDiff == nextDiff){
                       res[count] = arr[j];
                       count++;
                       j++;
                   } else if (prevDiff < nextDiff ) {
                       res[count] = arr[i];
                       i--;
                       count++;

                   }else {
                       res[count] = arr[j];
                       j++;
                       count++;
                   }

               }

               while (count<k && i>=0){

                   res[count] = arr[i];
                   i--;
                   count++;
               }

               while (count<k && j<n){
                   res[count] = arr[j];
                   j++;
                   count++;
               }


           }

 

       }

       return res;
   }

    public static int crossOverPoint(int arr[] , int x){
        int low = 0 ;
        int high = arr.length-1;
        int mid=0;
        if (arr.length==2){
            if ((Math.abs(arr[0]-x))<(Math.abs(arr[1]-x))){
                return 0;
            }else {
                return 1;
            }
        }else {
            while (low<=high){
                 mid = low + (high - low)/2;

                if (
                        arr[mid] == x ||
                                mid == arr.length-1 ||
                                mid == 0 ||
                                ((Math.abs(arr[mid]-x)<Math.abs(arr[mid+1]-x)) &&
                                        (Math.abs(arr[mid]-x)<=Math.abs(arr[mid-1]-x)))
                )
                {

                    return mid;
                }else if(arr[mid]>x){
                    high = mid -1;

                }else {
                    low = mid+1;
                }
            }
            return mid;
        }


    }

}

