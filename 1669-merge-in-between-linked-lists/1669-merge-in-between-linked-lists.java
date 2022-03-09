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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        //Get a-1 "th Node.
        
        ListNode heaven = list1;
        
        for(int i=0;i<a-1;i++){
            heaven = heaven.next;
        }
        
        //heaven now points to the a-1 "th Node.
        
        //Now get the b "th Node.
        
        int jumps = b-a+1;
        
        ListNode hell = heaven;
        
        for(int i=0;i<jumps;i++){
            hell = hell.next;
        }
        
        heaven.next = list2;
        ListNode tail = list2;
        while(tail.next!=null){
            tail = tail.next;
        }
        
        tail.next = hell.next;
        
        return list1;
    }
}