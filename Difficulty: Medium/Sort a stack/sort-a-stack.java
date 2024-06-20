//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;
import java.util.Stack;

class SortedStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Stack<Integer> s = new Stack<>();
            int n = sc.nextInt();
            while (n-- > 0) s.push(sc.nextInt());
            GfG g = new GfG();
            Stack<Integer> a = g.sort(s);
            while (!a.empty()) {
                System.out.print(a.peek() + " ");
                a.pop();
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        //to store the values of stack in array
        int[] arr = new int[s.size()];
        int pointer = 0;
        
        while(!s.isEmpty()){
            arr[pointer] = s.pop(); //make stack empty.
            pointer++;
        }
        Arrays.sort(arr);
        
        //keep the sorted stack back in old stack;
        for(int i=0;i<arr.length;i++){
            s.add(arr[i]);
        }
        
        return s;
    }
}