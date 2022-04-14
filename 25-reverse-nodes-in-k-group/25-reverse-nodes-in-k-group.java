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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = new ListNode(-1);
        ListNode pt = prev;
        
        while(head!=null){
            ListNode curr = new ListNode(-1);
            ListNode ct = curr;
            
            int rev = k;
            while(head != null && rev > 0){
                ct.next = new ListNode(head.val);
                ct = ct.next;
                head = head.next;
                rev--;
            }
            
            if(rev == 0){
                ListNode x = curr.next;
                curr = reverse(curr.next);
                pt.next = curr;
                pt = x;
            } else {
                pt.next = curr.next;
            }
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
    
    public static ListNode reverse(ListNode head){
        ListNode prev = null, curr = head;
        while(curr!=null){
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        
        return prev;
    }
}