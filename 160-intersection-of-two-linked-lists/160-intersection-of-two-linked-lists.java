/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==headB) return headA;
        
        int size1 = 1;
        int size2 = 1;
        ListNode h1 = headA;
        while(h1!=null){
            h1 = h1.next;
            size1++;
        }
        ListNode h2 = headB;
        while(h2!=null){
            h2 = h2.next;
            size2++;
        }
        
        //If both linked lists are different.
        
        int diff = Math.abs(size1-size2);
        
         h1 = headA;
         h2 = headB;
        
        if(size1>size2){
            while(diff-->0){
                h1 = h1.next;
            }
        } else if (size2>size1){
            while(diff-->0){
                h2 = h2.next;
            }
        }
        
        while(h1!=h2){
            h1 = h1.next;
            h2 = h2.next;
        }
        
        return h1;
    }
}