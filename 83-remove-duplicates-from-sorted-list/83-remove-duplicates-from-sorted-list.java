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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        ListNode dt = dummy;
        
        while(head!=null){
            if(dummy == dt){
                dt.next = head;
                dt = head;
                head = head.next;
            }
            
            while(head!=null && dt.val == head.val){
                head = head.next;
            }
            
            dt.next = head;
            dt = head;
        }
        
        return dummy.next;
    }
}