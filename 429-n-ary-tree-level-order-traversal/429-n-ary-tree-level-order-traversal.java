/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<Node> mainQ = new ArrayDeque<>();
        mainQ.add(root);
        Queue<Node> childQ = new ArrayDeque<>();
        List<Integer> level = new ArrayList<>();
        
        while(mainQ.size()>0){
            Node curr = mainQ.remove();
            level.add(curr.val);
            for(Node child : curr.children){
                childQ.add(child);
            }
            if(mainQ.size()==0){
                res.add(level);
                level = new ArrayList<>();
                while(childQ.size()>0)
                    mainQ.add(childQ.remove());
            }
        }
        
        return res;
    }
}