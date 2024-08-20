//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Fill the adjacency list
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // Initialize distance array
        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        distance[src] = 0;
        
        // BFS Queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        
        // BFS to find shortest paths
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int neighbor : graph.get(currentNode)) {
                if (distance[neighbor] == -1) { // Not visited
                    distance[neighbor] = distance[currentNode] + 1;
                    queue.add(neighbor);
                }
            }
        }
        
        return distance;
    }
}

