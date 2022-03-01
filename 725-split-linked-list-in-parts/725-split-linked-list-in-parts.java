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
    int size = 0;
    
    public ListNode[] splitListToParts(ListNode head, int k) {
        helper(head);
        int[] arr = new int[k]; 
        int least = size/k;
        int rem = size%k;
        for(int i=0;i<k;i++){
            arr[i] = (rem<=0) ? least : least + 1;
            rem--;
        }
        
        // for(int val : arr)
        //     System.out.print(val + " ");
        // System.out.println();
        
        ListNode[] res = new ListNode[k];
        int idx = 0;
        while(head!=null){
            res[idx] = head;
            ListNode curr = head;
            for(int i=0;i<arr[idx]-1;i++){
                curr = curr.next;
            }
            head = curr.next;
            curr.next = null;
            idx++;
        }
        
        return res;
    }
    
    public void helper(ListNode head){
        while(head!=null){
            size++;
            head = head.next;
        }
    }
}