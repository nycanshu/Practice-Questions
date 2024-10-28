//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            v = new Solution().removeDuplicate(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    ArrayList<Integer> removeDuplicate(int arr[]) {
        // code here
       
         ArrayList<Integer> l = new ArrayList<>();
      
         //Take frequency array of 101 size because arr[i]<=100
        int[] freq = new int[101];
        for(int i = 0 ; i < arr.length ; i++){
         
            //if freq[arr[i]] = 0 it means that this number is not visited yet
           if(freq[arr[i]]==0) l.add(arr[i]);
         
           //increase its frequency by one
           freq[arr[i]]++;
        }
        return l;
    }
}