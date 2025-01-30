//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                ans.sort((list1, list2) -> {
                    int size = Math.min(list1.size(), list2.size());
                    for (int i = 0; i < size; i++) {
                        if (!list1.get(i).equals(list2.get(i))) {
                            return list1.get(i) - list2.get(i);
                        }
                    }
                    return list1.size() - list2.size();
                });

                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
   public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
        int[] queens = new int[n]; // queens[i] represents the row of the queen in column i
        solveNQueens(queens, 0, n, solutions);
        return solutions;
    }

    private void solveNQueens(int[] queens, int col, int n, ArrayList<ArrayList<Integer>> solutions) {
        if (col == n) {
            // All queens placed, add the current solution
            ArrayList<Integer> solution = new ArrayList<>();
            for (int row : queens) {
                solution.add(row + 1); // Convert 0-based row index to 1-based
            }
            solutions.add(solution);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isValidPlacement(queens, col, row)) {
                queens[col] = row;
                solveNQueens(queens, col + 1, n, solutions);
            }
        }
    }

    private boolean isValidPlacement(int[] queens, int col, int row) {
        for (int prevCol = 0; prevCol < col; prevCol++) {
            int prevRow = queens[prevCol];
            if (prevRow == row || Math.abs(prevRow - row) == col - prevCol) {
                return false; // Same row or same diagonal
            }
        }
        return true;
    }
}