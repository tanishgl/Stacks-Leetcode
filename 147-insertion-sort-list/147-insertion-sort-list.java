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
    public ListNode insertionSortList(ListNode head) {
        if(head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        
        while(head!=null){
            ListNode iter = dummy;
            ListNode item = head;
            head = head.next;
            
            while(iter.next != null && iter.next.val > item.val){
                iter = iter.next;
            }
            
            item.next = iter.next;
            iter.next = item;
        }
        
        return reverse(dummy.next);
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev = null, curr = head, ahead = null;
        
        while(curr != null){
            ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        
        return prev;
    }
}