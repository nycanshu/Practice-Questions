//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        
    
        int r= matrix.length;
        int c = matrix[0].length;
        ArrayList<Integer> result = new ArrayList<>();
        
        int top=0, left=0, right = c-1, bottom= r-1;
        
        while(top<=bottom && right>= left){
            
            // first row
            for(int col= left; col<=right; col++)
                result.add(matrix[top][col]);
          // update top
           top++; 
           
           // rightmost column; row<=bottom will check top>r condition
           for(int row=top; row<=bottom; row++)
               result.add(matrix[row][right]);
           
           // update right
           right--;
           
           // bottom and also check whether 1 row left
           
         if(top<= bottom){
             
          for(int col= right; col>=left; col--)
            result.add(matrix[bottom][col]);
          // update bottom
           bottom--; 
        
             
         }
         
         // left and also check whether 1  column left
         if(left<=right){
             
          for(int row=bottom; row>=top; row--)
            result.add(matrix[row][left]);
          // update bottom
           left++; 
         }
           
        }
        
        return result;
    }
}