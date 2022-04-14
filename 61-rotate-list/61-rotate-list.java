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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        int len = size(head);
        k %= len;
        int a = len - k;
        int b = k;
        
        //Reverse the first a nodes.
        ListNode sec = head;
        ListNode prev = head;
        for(int i=0;i<a;i++){
            prev = sec;
            sec = sec.next;
        }
        
        prev.next = null;
        ListNode x = head;
        prev = reverse(head);
        sec = reverse(sec);
        x.next = sec;

        return reverse(prev);
        
    }
    
    public static void display(ListNode head){
        while(head!=null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    
    public int size(ListNode head){
        int ans = 0;
        while(head!=null){
            ans++;
            head = head.next;
        }
        return ans;
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