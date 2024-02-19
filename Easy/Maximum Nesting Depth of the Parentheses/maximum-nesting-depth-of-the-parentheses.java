//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            sc.nextLine();
            String s;
            s = sc.next();
            
            Solution obj = new Solution();
            int res = obj.maxDepth(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxDepth(String s) {
        // code here
        int c=0;
        int max=0;
        Stack <Character> sta=new Stack <>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                sta.push(')');
                c++;
            }
            else if(s.charAt(i)==')')
            {
                sta.pop();
                c--;
            }
            if(max<c)
            {
                max=c;
            }
        }
        return max;
    }
}