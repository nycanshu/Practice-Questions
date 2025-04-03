//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Node
{
    int x,y,t;
    Node(int x,int y,int t)
    {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}
class Solution {
    public int orangesRotting(int[][] mat) {
        if(mat==null||mat.length==0)
        return -1;
        
        int[][] grid = Arrays.stream(mat)
        .map(x->Arrays.copyOf(x,x.length)).
        toArray(int[][]::new);
        
        int[][] dxdy = {{-1,0},
                        {0,1},
                        {1,0},
                        {0,-1}};
                
        ArrayDeque<Node> q = new ArrayDeque<>();
        int countFresh = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==2)
                {
                    q.offer(new Node(i,j,0));
                    //grid[i][j] = 2;
                }
                else if(mat[i][j]==1)
                countFresh++;
            }
        }
        int minTime = 0;
        int count = 0;
        while(!q.isEmpty())
        {
            Node currNode = q.poll();
            int x = currNode.x;
            int y = currNode.y;
            int t = currNode.t;
            minTime = Math.max(minTime,t);
            
            for(int i=0;i<4;i++)
            {
                int newX = x+dxdy[i][0];
                int newY = y+dxdy[i][1];
                
                if((newX>=0 && newX<m)&&(newY>=0&&newY<n)
                && mat[newX][newY] ==1  && grid[newX][newY] != 2)
                {
                    q.offer(new Node(newX,newY,t+1));
                    grid[newX][newY] = 2;
                    count++;
                }
            }
        }
        
        if(countFresh == count)
        return minTime;
        else
        return -1;
    }
}