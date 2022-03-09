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
    public int[] nextLargerNodes(ListNode head) {
        int[] arr = new int[size(head)];
        ListNode temp = head;
        int idx = 0;
        while(temp!=null){
            arr[idx++] = temp.val;
            temp = temp.next;
        }
        
        int[] res = new int[size(head)];
        Arrays.fill(res, 0);
        Stack<Integer> st = new Stack<>();
        st.push(0);
        
        for(int i=1;i<arr.length;i++){
            while(st.size()>0 && arr[i]>arr[st.peek()]){
                res[st.pop()] = arr[i];
            }
            st.push(i);
        }
        
        return res;
    }
    
    public int size(ListNode head){
        int sz = 0;
        while(head!=null){
            head = head.next;
            sz++;
        }
        return sz;
    }
}