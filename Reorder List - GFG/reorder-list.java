// { Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

  public class ReorderList {
    Node head; // head of lisl
    Node last; // last of linked list

    /* Linked list Node*/

    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            last = head;
        } else {
            // Node temp = head;
            // while (temp.next != null) temp = temp.next;

            last.next = node;
            last = last.next;
        }
    }
    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            ReorderList llist = new ReorderList();

            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            llist.head = new gfg().reorderlist(llist.head);

            llist.printList();

            t--;
        }
    }
}// } Driver Code Ends


/* Following is the Linked list node structure */

/*class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/

class gfg {
    Node reorderlist(Node head) {
        Node mid = middle(head);
        Node right = mid.next;
        mid.next = null;
        right = reverse(right);
        
        Node dummy = new Node(-1);
        Node tail = dummy;
        while(head!=null || right!=null){
            if(head!=null){
                tail.next = head;
                tail = head;
                head = head.next;
            }
            
            if(right!=null){
                tail.next = right;
                tail = right;
                right = right.next;
            }
        }
        
        return dummy.next;
    }
    
    Node middle(Node head){
        Node slow = head, fast = head;
        Node curr = head;
        while(fast!=null && fast.next!=null){
            curr = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast==null) return curr;
        return slow;
    }
    
    Node reverse(Node head){
        Node prev = null, curr = head;
        while(curr!=null){
            Node ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        return prev;
    }
}
