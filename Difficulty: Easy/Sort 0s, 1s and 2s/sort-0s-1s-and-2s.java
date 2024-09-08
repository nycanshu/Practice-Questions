//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> a = new ArrayList<>();

            for (String s : inputArray) {
                a.add(Integer.parseInt(s));
            }

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) {
        // code here
        int left=0;
        int mid=0;
        int right=arr.size()-1;
        
        while(mid<=right){
            if(arr.get(mid)==0){
                swap(arr, left, mid);
                left++;
                mid++;
            }else if(arr.get(mid)==1){
                mid++;
            }else{
                swap(arr, mid, right);
                right--;
            }
        }
       
    }
    public static void swap(ArrayList<Integer> arr, int a, int b){
        int temp=arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, temp);
    }
}