//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            long[] a = new long[input.length];

            for (int i = 0; i < input.length; i++) {
                a[i] = Long.parseLong(input[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.minCost(a));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    // Function to return the minimum cost of connecting the ropes.
    public long minCost(long[] arr) {
        
        // your code here
        int n = arr.length;
        
        PriorityQueue<Long>minheap = new PriorityQueue<>();
        
        for(long length :arr){
            minheap.add(length);
        }
         long totalcost = 0;
         while(minheap.size()>1){
             long first = minheap.poll();
             long second = minheap.poll(); // taking out 2 min elements 
             long sum = first+second;
             minheap.add(sum);
             totalcost+=sum;
             
         }
         
         return totalcost;
        
    }
}