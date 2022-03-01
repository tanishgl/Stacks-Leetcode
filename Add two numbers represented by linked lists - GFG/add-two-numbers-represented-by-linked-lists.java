// { Driver Code Starts
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

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        first = reverse(first);
        second = reverse(second);
        
        Node dummy = new Node(-1);
        Node tail = dummy;
        
        int carry = 0;
        
        while(carry >0 || first!=null || second!=null){
            int d1 = (first==null) ? 0 : first.data;
            int d2 = (second==null) ? 0 : second.data;
            int sum = d1 + d2 + carry;
            Node temp = new Node(sum%10);
            tail.next = temp;
            tail = temp;
            carry = sum/10;
            first = (first==null) ? null : first.next;
            second = (second==null) ? null : second.next;
        }
        
        return reverse(dummy.next);
        
    }
    
    static Node reverse(Node head){
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