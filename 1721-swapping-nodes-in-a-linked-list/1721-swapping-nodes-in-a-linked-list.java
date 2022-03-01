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
        ListNode left = get(head, k);
        int size = sizeLL(head);
        ListNode right = get(head, size-k+1);
        int temp = left.val;
        left.val = right.val;
        right.val = temp;
        return head;
    }
    
    public int sizeLL(ListNode head){
        int ans = 0;
        while(head!=null){
            head = head.next;
            ans++;
        }
        
        return ans;
    }
    
    public ListNode get(ListNode head, int k){
        ListNode curr = head;
        for(int i=0;i<k-1;i++)
            curr = curr.next;
        return curr;
    }
}