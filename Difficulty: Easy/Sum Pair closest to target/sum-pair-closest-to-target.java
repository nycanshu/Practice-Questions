//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        
        Arrays.sort(arr);
        int st = 0, end = arr.length-1, currClose = Integer.MAX_VALUE;
        List<Integer> ans = new ArrayList<>();
        
        while(st<end){
            int sum = arr[st] + arr[end];
            
            if(Math.abs(target - sum) < currClose){
                currClose = Math.abs(target-sum);
                
                ans.clear();
                ans.add(arr[st]);
                ans.add(arr[end]);
            }
            if(sum < target){
                st++;
            }
            
            else if(sum > target){
                end--;
            }
            else{
                return ans;
            }
        }
        return ans;
    }
}