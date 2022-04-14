/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode prev = new ListNode(-1);
        ListNode pt = prev;
        int n = 1;
        
        while(head != null){
            ListNode curr = new ListNode(-1);
            ListNode ct = curr;
            
            int rev = n; 
            
            while(head != null && rev > 0){
                ct.next = new ListNode(head.val);
                ct = ct.next;
                head = head.next;
                rev--;
            }
        
            if(rev > 0){
                n = n - rev;
            }
            
            
            if(n%2==0){
                ListNode x = curr.next;
                curr = reverse(curr.next, n);
                pt.next = curr;
                pt = x;
            } else {
                pt.next = curr.next;
                while(pt.next!=null){
                    pt = pt.next;
                }
            }
            
            n++;
        }
        
        return prev.next;
    }
    
    public static void display(ListNode head){
        while(head!=null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static ListNode reverse(ListNode head, int k){
        ListNode prev = null, curr = head;
        while(curr!=null && k>0){
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
            k--;
        }
        
        return prev;
    }
}