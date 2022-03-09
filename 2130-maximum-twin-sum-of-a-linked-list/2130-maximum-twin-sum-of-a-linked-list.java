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
    public int pairSum(ListNode head) {
        ListNode middle = mid(head);
        ListNode right = middle.next;
        middle.next = null;
        right = reverse(right);
        int sum = 0;
        while(head!=null){
            sum = Math.max(sum, head.val + right.val);
            head = head.next;
            right = right.next;
        }
        
        return sum;
    }
    
    public ListNode mid(ListNode head){
        ListNode slow = head, fast = head, curr = head;
        
        while(fast!=null){
            curr = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return curr;
    }
    
    public ListNode reverse(ListNode head){
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