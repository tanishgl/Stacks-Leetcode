/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
//         Node dummy = new Node(-1);
//         Node tail = dummy;
        
//         HashMap<Node, Node> hm = new HashMap<>();
        
//         Node curr = head;
//         while(curr!=null){
//             //Create a new Node.
//             Node new_node = new Node(curr.val);
//             //Update the tail.
//             tail.next = new_node;
//             tail = new_node;
//             //Update the hashmap.
//             hm.put(curr, new_node);
//             //Update the counter i.e. curr node.
//             curr = curr.next;
//         }
        
//         curr = head;
        
//         while(curr!=null){
//             Node randomNode = curr.random;
//             if(randomNode!=null){
//                 randomNode = hm.get(randomNode);
//             }
            
//             hm.get(curr).random = randomNode;
//             curr = curr.next;
//         }
        
//         return dummy.next;
        
        
        //Optimized problem.
        
        if(head==null) return null;
        
        //1. First add duplicate nodes between every pair of node.
        Node curr = head;
        while(curr!=null){
            Node temp = new Node(curr.val);
            temp.next = curr.next;
            curr.next = temp;
            curr = curr.next.next;
        }
        
        //2. Update the random pointers of duplicate added nodes.
        
        curr = head;
        while(curr!=null && curr.next!=null){
            Node randomNode = curr.random;
            if(randomNode!=null){
                randomNode = randomNode.next;
            }
            curr.next.random = randomNode;
            
            curr = curr.next.next;
        }
        
        //3. Extract the duplicate nodes.
        
        curr = head;
        Node dummy = curr.next;
        Node tail = dummy;
        
        while(curr!=null){
            Node duplicate = curr.next;
            curr.next = duplicate.next;
            if(duplicate.next!=null) duplicate.next = duplicate.next.next;
            curr = curr.next;
        }
        
        return dummy;
    }
}