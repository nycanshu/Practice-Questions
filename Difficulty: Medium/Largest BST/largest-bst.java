//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


// Class to store information about subtrees
class Data {
    int max, min, size;
    
    Data(int max, int min, int size) {
        this.max = max;
        this.min = min;
        this.size = size;
    }
}

class Solution {
    static Data dfs(Node root) {
        // Base case: if node is null, return sentinel values
        if (root == null) {
            return new Data(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        // Recursively process left and right subtrees
        Data leftSubtree = dfs(root.left);
        Data rightSubtree = dfs(root.right);

        // Check if the current node forms a valid BST with its subtrees
        if (root.data > leftSubtree.max && root.data < rightSubtree.min) {
            // This subtree is a valid BST
            int curSize = leftSubtree.size + rightSubtree.size + 1;
            int maxval = Math.max(root.data, rightSubtree.max);
            int minval = Math.min(root.data, leftSubtree.min);
            return new Data(maxval, minval, curSize);
        }

        // If not a valid BST, return a sentinel Data object
        // The size will be the max of left and right subtree sizes
        return new Data(Integer.MAX_VALUE, Integer.MIN_VALUE, 
                        Math.max(leftSubtree.size, rightSubtree.size));
    }

    static int largestBst(Node root) {
        // Initiate DFS and return the size of the largest BST
        Data result = dfs(root);
        return result.size;
    }
}