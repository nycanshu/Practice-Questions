//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int sumOfMiddleElements(int[] arr1, int[] arr2) {
        List<Integer> merged = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                merged.add(arr1[i]);
                i++;
            }else{
                merged.add(arr2[j]);
                j++;
            }
        }
        
        // add rest of elements
        while(i < arr1.length){
            merged.add(arr1[i]);
            i++;
        }
        // left values from array 2
        while(j < arr2.length){
            merged.add(arr2[j]);
            j++;
        }
        
        int mid = merged.size() / 2;
        if (merged.size() % 2 == 0) {
            return merged.get(mid - 1) + merged.get(mid);
        } else {
            return merged.get(mid);
        }
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.sumOfMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends