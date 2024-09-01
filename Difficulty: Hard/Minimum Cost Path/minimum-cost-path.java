//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return the minimum cost to react at bottom
    //right cell from top left cell.
    private int[] rowIndex = new int[]{-1, 0, 0, 1};
    private int[] colIndex = new int[]{0, -1, 1, 0};
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] node1, int[] node2) {
                return node1[2] - node2[2];
            }
        });
        minHeap.add(new int[]{0, 0, grid[0][0]});
        int[][] distance = new int[grid.length][grid[0].length];
        Arrays.stream(distance).forEach(arr -> Arrays.fill(arr, -1));
        while (!minHeap.isEmpty()) {
            int[] node = minHeap.poll();
            if (distance[node[0]][node[1]] == -1) {
                distance[node[0]][node[1]] = node[2];
                for (int i = 0; i < rowIndex.length; i++) {
                    int row = node[0] + rowIndex[i];
                    int col = node[1] + colIndex[i];
                    if (row >= 0 && row < grid.length && col >= 0 && col < grid[row].length && distance[row][col] == -1) {
                        minHeap.add(new int[]{row, col, node[2] + grid[row][col]});
                    }
                }
            }
        }
        return distance[grid.length - 1][grid[0].length - 1];
    }
}