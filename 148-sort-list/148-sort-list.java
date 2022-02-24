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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode mid = middle(head);
        ListNode right = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        right = sortList(right);
        return merge(left, right);
    }
    
    public ListNode middle(ListNode head){
        if(head==null || head.next==null) return head;
        
        ListNode slow = head, fast = head;
        ListNode curr = slow;
        
        while(fast!=null && fast.next!=null){
            curr = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast==null) return curr;
        return slow;
    }
    
    public ListNode merge(ListNode h1, ListNode h2){
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        
        while(h1!=null && h2!=null){
            if(h1.val<=h2.val){
                tail.next = h1;
                tail = h1;
                h1 = h1.next;
            } else {
                tail.next = h2;
                tail = h2;
                h2 = h2.next;
            }
        }
        
        if(h1==null) tail.next = h2;
        else if (h2==null) tail.next = h1;
        
        return dummy.next;
    }
}