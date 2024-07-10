//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public boolean isValid(int nrow , int ncol , int n){
        return nrow >= 0 && nrow < n && ncol >= 0 && ncol < n ;
        
       
    }
    public int MaxConnection(int grid[][]) {
        
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        //step - 1
         int dr[] = {-1 , 0 , 1 , 0};
         int dc[] = {0 , 1 , 0 , -1};
         
        for(int row = 0 ; row < n ; row++){
            for(int col = 0 ; col < n ; col++){
                if(grid[row][col] == 0) continue;
                
                for(int i = 0 ; i<4 ; i++){
                    int nrow = row + dr[i];
                    int ncol = col + dc[i];
                    
                    if(isValid(nrow , ncol , n) && grid[nrow][ncol] == 1){
                        int node = row * n + col;
                        int adjnode = nrow * n + ncol;
                        
                        ds.unionBySize(node , adjnode);
                    }
                }
            }
        }
        //step - 2
        int ans = 0;
        
        for(int row = 0 ; row < n ; row++){
            for(int col = 0 ; col < n ; col++){
                if(grid[row][col] == 1) continue;
                
                HashSet<Integer> set = new HashSet<>();
                
                for(int i = 0 ; i<4 ; i++){
                    int nrow = row + dr[i];
                    int ncol = col + dc[i];
                    
                    if(isValid(nrow , ncol , n) && grid[nrow][ncol] == 1){
                        set.add(ds.findParent(nrow * n + ncol));
                    }
                }
                 // now remove all elements from the set
                 
                int sizeTotal = 0;
                for (Integer i : set) {
                     sizeTotal += ds.size.get(i);
                }
                ans = Math.max(ans, sizeTotal + 1 );
            }
        }
        // edge case if All the cells have 1 
        
        for(int i = 0 ; i<n*n ; i++){
            ans = Math.max(ans , ds.size.get(ds.findParent(i)));
        }
        
        return ans;
    }
    
}

class DisjointSet{
    List<Integer> parent  = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n){
        for(int i = 0 ; i<= n ; i++){
            parent.add(i);
            size.add(1);
        }
    }
    
     int findParent(int u){
        
        if(u == parent.get(u))
        return u;
        
        //path Compression
        int ultiP_u = findParent(parent.get(u));
        parent.set(u , ultiP_u);
        return parent.get(u);
    }
    
    void unionBySize(int u , int v){
        int ultP_u = findParent(u);
        int ultP_v = findParent(v);
        
        if(ultP_v == ultP_u) return;
        
        if(size.get(ultP_u) < size.get(ultP_v)){
            parent.set(ultP_u , ultP_v );
            size.set(ultP_v , size.get(ultP_v) + size.get(ultP_u));
        }
        else {
            parent.set(ultP_v , ultP_u);
            size.set(ultP_u , size.get(ultP_v) + size.get(ultP_u));
        }
    }
}

