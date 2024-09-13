//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        ArrayList<Integer>postiveArray =new ArrayList<>();
        ArrayList<Integer>negativeArray =new ArrayList<>();
        for(int num: arr)
        {
            if(num<0)
            negativeArray.add(num);
            else
            postiveArray.add(num);
        }
        int positerator=0,negiterator=0,mainiterator=0;
        
        while((positerator<postiveArray.size()) && (negiterator<negativeArray.size()))
        {
            arr.set(mainiterator++,postiveArray.get(positerator++));
            arr.set(mainiterator++,negativeArray.get(negiterator++));
        }
        if(postiveArray.size()<negativeArray.size())
        {
            while(negiterator<negativeArray.size())
            {
                arr.set(mainiterator++,negativeArray.get(negiterator++));   
            }
        }else
        {
            while(positerator<postiveArray.size())
            {
                arr.set(mainiterator++,postiveArray.get(positerator++));   
            }
        }
    }
}