//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
            List<List<Integer>> ans = new Solution().CombinationSum2(a, n, k);
            for (List<Integer> list : ans) {
                for (int x : list) ot.print(x + " ");
                ot.println();
            }
            if (ans.size() == 0) ot.println();
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution
{
    public void function(int[] a,int n,int target,int i,List<List<Integer>> ans,List<Integer> l,int sum)
    {
        //base case
        if(i==n)
        {
            if(sum==target && !ans.contains(l))
            {
                ans.add(new ArrayList(l));
            }
            return;
        }
        
        //if we am at index i,we have to 2 options--> take or not_take
        //if we take the value at index i
        if(a[i]<=target && sum<=target)//if we remove the sum<=target --> give TLE beacause it remove some unwanted calls
        {
            sum+=a[i];
            l.add(a[i]);
            function(a,n,target,i+1,ans,l,sum);
            l.remove(l.size()-1);
            sum-=a[i];
        }
        
        //if we will take the value at index i
        function(a,n,target,i+1,ans,l,sum);
    }
    
public List<List<Integer>> CombinationSum2(int a[], int n, int k)
{
//Code Here.
//since there may be dublicate cobination due to repetative element, so we will use set 
//later we will convert set to list
List<List<Integer>> ans=new ArrayList<>();
List<Integer> l=new ArrayList<>();
Arrays.sort(a);
function(a,n,k,0,ans,l,0);//0--> start form 0 and annother 0 for sum track
 
return ans;
}
}