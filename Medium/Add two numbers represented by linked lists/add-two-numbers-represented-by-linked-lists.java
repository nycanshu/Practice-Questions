//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution {
    // Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second) {
        if (first == null)
            return second;
        if (second == null)
            return first;

     first = rev(first);
     second = rev(second);
    return add(first,second);
     
    }
    static Node rev(Node head)
    {
        Node cur = null;
        Node prev = null;
        Node nn = head;
        while(nn != null)
        {
            cur = nn.next;
            nn.next = prev;
            prev = nn;
            nn = cur;
        }
        return prev;
    }
    static Node add(Node first,Node second)
    {
        Node f = null;
        Node s =null;
        int carry =0;
      while(first != null  || second != null || carry != 0 ) 
      {
          int val1 =0;
          int val2 =0;
          if(first != null)
          {
              val1 = first.data;
               first = first.next;
          }
          if(second != null)
          {
              val2 = second.data;
               second = second.next;
          }
          
          int sum = carry + val1 + val2;
          
          int digit = sum %10;
          carry = sum /10;
          
       Node cur = new Node(digit);
        if(f == null)
        {
            f = cur;
            s = cur;
            
            
        }
        else
        {
            
            s.next = cur;
            s = cur;
        }
      }
      return rev(f);
    }
    
}

