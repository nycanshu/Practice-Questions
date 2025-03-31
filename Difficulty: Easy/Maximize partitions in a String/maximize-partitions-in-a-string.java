//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            int ans = obj.maxPartitions(s);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxPartitions(String s) {
        // code here
        int len= s.length();
        Map<Character, Integer> map= new HashMap<>();
        for(int i=0; i< len; i++)
        {
        map.put(s.charAt(i),i);
        }
        int j=0, maxI=-1, cnt=0;
        
        while(j< len)
        {
            char ch=s.charAt(j);
            maxI=Math.max(maxI, map.get(ch));
            if(maxI==j){
            cnt++;    
            }
            j++;
        }
        return cnt;
    }
}