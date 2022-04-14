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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //always get the n+1 th node.
        n++;
        
        ListNode fast = head;
        while(fast!=null && n>0){
            fast = fast.next;
            n--;
        }
        
        if(fast == null && n==1){
            return head.next;
        } else if (n > 1){
            return null;
        }
        
        ListNode slow = head;
        
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return head;
    }
}