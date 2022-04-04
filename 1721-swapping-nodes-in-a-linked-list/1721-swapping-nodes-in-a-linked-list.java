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
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        
        ListNode firstK = head;
        for(int i=1;i<k;i++)
            firstK = firstK.next;
        
        ListNode slow = head, secK = firstK;
        while(secK != null && secK.next != null){
            slow = slow.next;
            secK = secK.next;
        }
        
        int temp = slow.val;
        slow.val = firstK.val;
        firstK.val = temp;
        
        return head;
    }
}