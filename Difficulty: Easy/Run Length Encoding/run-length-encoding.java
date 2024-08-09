//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.encode(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String encode(String s) {
        // code here
        int i=0;
        int j=0;
        StringBuilder res=new StringBuilder();
        int count=0;
        while(i<s.length())
        {
            if(s.charAt(j)==s.charAt(i))
            {
                count++;
                i++;
            }
            
            else
            {
                res=res.append(s.charAt(j)).append(count);
                
                count=0;
                j=i;
            }
            
        }
        
        res=res.append(s.charAt(j)).append(count);
        return res.toString();


    }
}
    