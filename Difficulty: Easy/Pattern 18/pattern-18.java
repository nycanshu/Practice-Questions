//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            obj.printTriangle(n);
        }
    }
}
// } Driver Code Ends


class Solution {
void printTriangle(int n) {
        for(int i =0; i<n;i++){
            //Gives the Last letter position
            char lastLetter = (char)('A'+n-1);
            // loop Will from last letter to (lastletter - index)
            for(char ch = (char)lastLetter; ch>=(char)(lastLetter-i); ch--){
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }
}