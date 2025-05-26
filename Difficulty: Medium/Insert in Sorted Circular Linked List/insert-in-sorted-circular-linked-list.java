/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    public Node sortedInsert(Node head, int data) {
        // code here
        Node newNode = new Node(data);
       // step 1 check the empty list .
       if(head == null){
           newNode.next = newNode;
           return newNode;
       }
       //step -2 Insert in between the nodes 
       Node current= head;
       while(true){
           if(current.data <= data && data <= current.next.data){
               break;
           }
           
          // step - 3 end of list reached rotation point came .
          if(current.data > current.next.data){
              if(data>=current.data || data <= current.next.data){
                  break;
              }
          }
          current = current.next;
            // step 4 come back to head insert anywhere 
            if(current == head){
                break;
            }
       }
       newNode.next = current.next;
       current.next = newNode;
      
      if(data < head.data){
          return newNode;
      }
      return head;
    
    }
}