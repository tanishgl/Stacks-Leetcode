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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        if(left == 1) return reverse(head, right-left+1);
        
        ListNode prev = null, temp = head;
        int l = left;
        while(left-->1){
            prev = temp;
            temp = temp.next;
        }
        
        prev.next = reverse(temp, right-l+1);
        return head;
    }
    
    public ListNode reverse(ListNode head, int k){
        ListNode prev = null, curr = head, ahead = null;
        
        while(curr!=null && k-->0){
            ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        
        head.next = curr;
        return prev;
    }
}