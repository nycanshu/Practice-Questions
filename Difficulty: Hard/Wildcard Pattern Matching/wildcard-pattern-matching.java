//{ Driver Code Starts
import java.util.*;

class WildcardPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String pat = sc.nextLine();
            String text = sc.nextLine();
            Solution g = new Solution();
            System.out.println(g.wildCard(pat, text));
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public int wildCard(String pattern, String str) {
        int  dp[][] = new int [pattern.length()+1][str.length()+1];
        for(int i=dp.length-1;i>=0;i--){
            for(int j =dp[0].length-1;j>=0;j--){
                if(i ==dp.length-1 &&j ==dp[0].length-1){
                    dp[i][j]=1;
                }else if(i ==dp.length-1){
                    dp[i][j]=0;
                }else if(j== dp[0].length-1){
                    if(pattern.charAt(i)=='*'){
                        dp[i][j]=dp[i+1][j];
                    }else{
                        dp[i][j]=0;
                    }
                }else{
                    if(pattern.charAt(i)=='?'){
                        dp[i][j]=dp[i+1][j+1];
                    }else if(pattern.charAt(i)=='*'){
                        dp[i][j]= dp[i+1][j]|dp[i][j+1];
                    }else if(pattern.charAt(i)==str.charAt(j)){
                        dp[i][j]=dp[i+1][j+1];
                        
                    }else{
                        dp[i][j]=0;
                    }
                }
                
            }
        }
        return dp[0][0];
        
    }
}