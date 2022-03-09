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
        if(head==null) return null;
        if(head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while(head!=null){
            if(head.next==null || head.next.val != head.val){
                tail.next = head;
                tail = head;
                head = head.next;
            } else {
                ListNode temp = head;
                while(temp.next!=null && temp.next.val == temp.val){
                    temp = temp.next;
                }
                head = temp.next;
            }
        }
        
        tail.next = null;
        
        return dummy.next;
    }
}