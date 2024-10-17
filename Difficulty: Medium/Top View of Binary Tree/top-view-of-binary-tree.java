//{ Driver Code Starts
// Initial Template for JAVA

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;


// } Driver Code Ends
// User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static class Pair{
        int kdist;
        Node node;
        
        Pair(int dist,Node n){
            kdist = dist;
            node = n;
        }
    }
    static ArrayList<Integer> topView(Node root) {
        // add your code 
        Queue < Pair> q = new LinkedList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();
        if(root == null) return al;
        Pair np = new Pair(0,root);
        q.add(np);
        int min = 0;
        int max = 0;
        while(q.size()> 0){
            int size = q.size();
            for(int i=0;i<size;i++){
                //remove
                Pair rem = q.poll();
                min = Math.min(min,rem.kdist);
                max = Math.max(max,rem.kdist);
                //work
                if(!hm.containsKey(rem.kdist)){
                    int key = rem.kdist;
                    int value = rem.node.data;
                    hm.put(key,value);
                }
                //add
                if(rem.node.left != null){
                    Pair np1 = new Pair(rem.kdist-1,rem.node.left);
                    q.add(np1);
                }
                if(rem.node.right != null){
                    Pair np2 = new Pair(rem.kdist+1,rem.node.right);
                    q.add(np2);
                }
            }
            
        }
        for(int i = min;i<= max;i++){
                int val = hm.get(i);
                al.add(val);
            }
        return al;
        
    }
}

//{ Driver Code Starts.

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Tree {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution ob = new Solution();

            ArrayList<Integer> vec = ob.topView(root);
            for (int x : vec) System.out.print(x + " ");
            System.out.println();

            t--;
        }
    }
}
// } Driver Code Ends