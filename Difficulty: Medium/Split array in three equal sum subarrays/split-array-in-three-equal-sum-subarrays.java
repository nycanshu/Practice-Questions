//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        while (testCases-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            Solution ob = new Solution();
            List<Integer> result = ob.findSplit(arr);

            if (result.get(0) == -1 && result.get(1) == -1 || result.size() != 2) {
                System.out.println("false");
            } else {
                int sum1 = 0, sum2 = 0, sum3 = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (i <= result.get(0))
                        sum1 += arr[i];

                    else if (i <= result.get(1))
                        sum2 += arr[i];

                    else
                        sum3 += arr[i];
                }
                if (sum1 == sum2 && sum2 == sum3) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int getCheckSum(int i,int[] arr,int sum){
        int currentSum=0;
        while(i<arr.length){
            currentSum+=arr[i];
            if(sum==currentSum){
                return i;
            }
            i++;
        }
        return i;
    }
    public List<Integer> findSplit(int[] arr) {
       List<Integer> res = new ArrayList<>();
       int sum=0,i=0,currentSum=0,partsCount=0;
       for(i=0;i<arr.length;i++){
           sum+=arr[i];
       }
       if(sum%3!=0){
           res.add(-1);
           res.add(-1);
           return res;
       }
       sum/=3;
       int idx1 = getCheckSum(0,arr,sum);
       int idx2 = getCheckSum(idx1+1,arr,sum);
       if(idx2>=arr.length){
           res.add(-1);
           res.add(-1);
           
       }
       else{
           res.add(idx1);
           res.add(idx2);
       }
       return res;
       
    }
}