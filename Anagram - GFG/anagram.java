//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    
		    if(obj.isAnagram(s1,s2))
		    {
		        System.out.println("YES");
		    }
		    else
		    {
		         System.out.println("NO");
		    }
		    
		    
		    
		}
	}
}
// } Driver Code Ends


class Solution
{    
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a,String b)
    {
        
        // Your code here
        int la = a.length();
        int lb = b.length();
        
        if(la!=lb) return false;
        
        else{
            char arr1[] = a.toCharArray();
            Arrays.sort(arr1);
            
            String s1 = new String(arr1);
            
            char arr2[] = b.toCharArray();
            Arrays.sort(arr2);
            String s2 = new String(arr2);
            
            return s1.equals(s2);
        }
        
    
    }
}