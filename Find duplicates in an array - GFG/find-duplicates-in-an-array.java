//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
     
        HashSet<Integer> list = new HashSet<>();  //created a set to store more than one time repeated values
        
        HashSet<Integer> arr_set = new HashSet<>(); //created a set to store arr values which are single present
        
        for(int val:arr){
            //if array element is already present in arr_set then add that into list
            if(!arr_set.add(val)){
                list.add(val);
                
            }
        }
        //convert the list into arraylist;
        
        ArrayList<Integer> ans = new ArrayList<>(list);
        
        Collections.sort(ans);
        if(ans.isEmpty()){
            ans.add(-1);
        }
           
        return ans; 
                
            
    }
}
