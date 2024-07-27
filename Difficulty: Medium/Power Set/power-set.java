//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        List<String> ans = new ArrayList<>();
        generate(s, 0, new StringBuilder(), ans);
        Collections.sort(ans);
        return ans;
    }
    
    public static void generate(String s, int i, StringBuilder curr, List<String> ans){
        if(i == s.length()){
            if(curr.length() > 0){
                ans.add(curr.toString());
            }
            return;
        }
        
        // Take the current character
        curr.append(s.charAt(i));
        generate(s, i + 1, curr, ans);
        curr.deleteCharAt(curr.length() - 1);
        
        // Don't take the current character
        generate(s, i + 1, curr, ans);
    }
}