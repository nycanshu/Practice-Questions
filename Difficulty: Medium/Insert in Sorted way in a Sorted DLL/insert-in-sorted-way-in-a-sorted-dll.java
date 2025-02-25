//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline character after t

        while (t-- > 0) {
            String input = sc.nextLine(); // Read the entire line for the array elements
            String[] values = input.split(" ");

            Node head = null, tail = null;
            for (String value : values) {
                int x = Integer.parseInt(value);
                if (head == null) {
                    head = new Node(x);
                    tail = head;
                } else {
                    tail.next = new Node(x);
                    tail.next.prev = tail;
                    tail = tail.next;
                }
            }

            int valueToInsert = sc.nextInt();
            if (sc.hasNextLine()) {
                sc.nextLine(); // Ignore the newline character after the value
            }

            Solution obj = new Solution();
            head = obj.sortedInsert(head, valueToInsert);
            printList(head);
        
System.out.println("~");
}

        sc.close();
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/*class of the node of the DLL is as
/*
class Node {
    int data;
    Node prev, next;
    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}
*/
class Solution {
    public Node sortedInsert(Node head, int x) {
        // Create a new node for the value x
        Node newNode = new Node(x);
        
        // Case 1: The list is empty
        if (head == null) {
            return newNode; // New node becomes the head
        }
        
        // Case 2: Insert at the beginning (before the head)
        if (x <= head.data) {  // Change from < to <= to handle duplicates
            newNode.next = head;
            head.prev = newNode;
            return newNode; // New node becomes the new head
        }
        
        // Case 3: Traverse the list to find the insertion point
        Node current = head;
        while (current != null && current.data < x) {
            current = current.next;
        }
        
        // Insert the new node before the current node
        newNode.prev = current != null ? current.prev : null; // Set the previous of newNode
        newNode.next = current; // Set the next of newNode
        
        // Update the previous node's next pointer if it exists
        if (current != null) {
            if (current.prev != null) {
                current.prev.next = newNode; // Link the previous node to newNode
            }
            current.prev = newNode; // Link the current node to newNode
        } else {
            // If current is null, this means we are at the end of the list
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next; // Find the last node
            }
            lastNode.next = newNode; // Link the last node to newNode
            newNode.prev = lastNode; // Link newNode back to the last node
        }
        
        return head; // Return the head of the list
    }
}