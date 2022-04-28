// { Driver Code Starts
import java.util.*;
import java.lang.*;

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

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = sc.nextInt();
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res);
            System.out.println();
        }
    }
    
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
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

class Solution
{
    public static Node reverse(Node node, int k)
    {
        Node prev = new Node(-1);
        Node pt = prev;
        int n = k;
        
        while(node!=null){
            Node curr = new Node(-1);
            Node ct = curr;
            
            k = n;
            while(node!=null && k>0){
                ct.next = node;
                ct = node;
                node = node.next;
                k--;
            }
            
            if(k==0){
                Node sn = curr.next;
                curr = reverseK(curr.next , n);
                pt.next = curr;
                pt = sn;
            } else {
                pt.next = reverseK(curr.next, n-k);
            }
        }
        
        return prev.next;
    }
    
    public static Node reverseK(Node head, int k){
        Node prev = null, curr = head, ahead = null;
        
        while(curr!=null && k>0){
            ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
            k--;
        }
        
        return prev;
    }
}

