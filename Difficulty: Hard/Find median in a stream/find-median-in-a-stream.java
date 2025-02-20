//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            ArrayList<Double> ans = ob.getMedian(nums);
            for (double i : ans) {
                System.out.printf("%.1f ", i);
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        // code here
        int n = arr.length;
        
        ArrayList<Double>ans = new ArrayList<>();
        
        
        PriorityQueue<Integer> lpq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rpq = new PriorityQueue<>();
        //rpq = rightPQ default java Min PriorityQueue
        //lpq = leftPQ it is max PriorityQueue
        for(int i = 0; i<n; i++){
            if(lpq.size() == rpq.size()){
                rpq.add(arr[i]);
                int val = rpq.remove();
                lpq.add(val);
                double ele = lpq.peek();
                ans.add(ele);
            }else{
                lpq.add(arr[i]);
                int val = lpq.remove();
                rpq.add(val);
                double ele = (lpq.peek()+rpq.peek());
                ans.add(ele/2);
            }
        }
        return ans;
    }
}

