//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
   public static int rotateDelete(ArrayList<Integer> arr) {
       int k=1;
        int n=arr.size();
        while(arr.size()>1){
            arr.add(0,arr.get(arr.size()-1));
            arr.remove(arr.size()-1);
            arr.remove(arr.size()-k);    
            n=arr.size();
            k++;
            if(k>n)break;;
        }
        return arr.get(0);
   }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> arr = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr.add(Integer.parseInt(token));
            }

            Solution obj = new Solution();
            int res = obj.rotateDelete(arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends