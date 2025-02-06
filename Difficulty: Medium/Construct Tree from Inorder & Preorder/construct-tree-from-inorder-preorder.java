//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            Node root = null;

            // Read inorder array
            String[] inorderStr = (br.readLine()).trim().split(" ");
            int inorder[] = new int[inorderStr.length];
            for (int i = 0; i < inorderStr.length; i++) {
                inorder[i] = Integer.parseInt(inorderStr[i]);
            }

            // Read preorder array
            String[] preorderStr = (br.readLine()).trim().split(" ");
            int preorder[] = new int[preorderStr.length];
            for (int i = 0; i < preorderStr.length; i++) {
                preorder[i] = Integer.parseInt(preorderStr[i]);
            }

            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder);
            postOrder(root);
            System.out.println();
        }
    }

    // Function to print postorder traversal of the tree
    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/

class Solution {
    public static Node buildTree(int inorder[], int preorder[]) {
        HashMap < Integer , Integer > map = new HashMap<>();
        
        for(int i = 0;i<inorder.length;i++){
            map.put (inorder[i] , i );
        }
        return split( inorder , 0,inorder.length-1 ,preorder , 0, map);
    }
    
    public static Node split( int []inorder , int instart, int inend , int[] preorder, int index ,HashMap<Integer , Integer> map ){
        Node root = new Node (preorder[index]);
        
        int mid = map.get (root.data);
          if(mid>instart){
        root.left = split(inorder, instart , mid-1,preorder, index+1,map );
          }
          if(mid<inend){
                 root.right = split(inorder , mid+1, inend ,preorder ,index + mid - instart +1,map);
          }
      
    return root;
    }
}


