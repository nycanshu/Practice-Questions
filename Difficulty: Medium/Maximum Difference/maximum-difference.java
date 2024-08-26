//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findMaxDiff(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    public int findMaxDiff(int[] a) {
        // code here
        int n = a.length;
        int ls[]=new int[n],ans=0;
	Stack<Integer> st=new Stack<>();
	for(int i=0;i<n;i++){
	    while(!st.isEmpty() && st.peek()>=a[i]) st.pop();
	    if(st.isEmpty()) ls[i]=0;
	    else ls[i]=st.peek();
	    st.push(a[i]);
	}
	st.clear();
	for(int i=n-1;i>=0;i--){
	    while(!st.isEmpty() && st.peek()>=a[i]) st.pop();
	    int x=0;
	    if(!st.isEmpty()) x=st.peek();
	    ans=Math.max(ans,Math.abs(ls[i]-x));
	    st.push(a[i]);
	}
	return ans;
    }
}
