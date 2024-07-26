//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine().trim());
            Solution obj = new Solution();
            if (obj.kPangram(str, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    boolean kPangram(String str, int k) {
        int count[]=new int[26];
        int cnt=0;
        
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)-'a'<26 && str.charAt(i)-'a'>=0 ){
                count[str.charAt(i)-'a']=1;
                cnt++;
            }
        }
        
        int cntalpha=0;
        for(int i=0;i<26;i++){
            if(count[i]==1)cntalpha++;
        }
        
        int r=cnt-cntalpha;
        
      int needtochange=26-cntalpha;
      if(needtochange<=r) {
    	  if(needtochange<=k) {
    		  return true;
    	  }else return false;
      }else return false;
        
    }
}