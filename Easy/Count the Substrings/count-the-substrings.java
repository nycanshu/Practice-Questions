//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countSubstring(S);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int countSubstring(String S) 
    { 
        // code here
        int result =0;
        int n = S.length();
        
        for(int i=0;i<n;i++){
            int[] lowerArr = new int[26];
            int[] upperArr = new int[26];
            for(int j=i;j<n;j++){
                char ch = S.charAt(j);
                if(ch>='a' && ch<='z'){
                    lowerArr[ch-'a']++;
                    
                }else{
                    upperArr[ch-'A']++;
                }
                
                
                if(lowerCount(lowerArr)==upperCount(upperArr)){
                    result++;
                }
                
            }
            
        }
        return result;
    }
    static int lowerCount(int[] arr){
        int res=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                res+=arr[i];
            }
        }
        return res;
    }
    static int upperCount(int[] arr){
        int res=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                res+=arr[i];
            }
        }
        return res;
    }
} 
