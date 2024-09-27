//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class ReverseInSize {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());

        while (t-- > 0) {

            String s[] = in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < s.length; i++) {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res, out);
            out.println();
        }
        out.close();
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
    }
}

// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/
class Solution{
    public static Node reverse(Node node, int k){
        Node prevStart=null,prevEnd=null,currStart=null,currEnd=null,temp[],head=null;
        int it=1;
        while(node!=null){
            if(currStart==null) currStart=node;
            if(it==k || node.next==null){
                currEnd=node;
                node=node.next; it=1;
                currEnd.next=null;
                temp=reverseLinkedList(currStart,currEnd);
                currStart=temp[0];
                currEnd=temp[1];
                if(prevStart==null && prevEnd==null){
                    head=currStart;
                    prevStart=currStart;
                    prevEnd=currEnd;
                }else{
                    prevEnd.next=currStart;
                    prevStart=currStart;
                    prevEnd=currEnd;
                }
                currStart=null;currEnd=null;
            }
            else if(it<k){
                node=node.next;
                it++;
            }
        }
        return head;
    }
    public static Node[] reverseLinkedList(Node start, Node end){
        Node res[]=new Node[2];
        Node newEnd=start;
        Node prev=null,curr=start,next=start.next;
        while(curr!=null){
            curr.next=prev;
            prev=curr;
            curr=next;
            if(next!=null)
            next=next.next;
        }
        res[0]=prev; res[1]=newEnd;
        return res;
    }
}