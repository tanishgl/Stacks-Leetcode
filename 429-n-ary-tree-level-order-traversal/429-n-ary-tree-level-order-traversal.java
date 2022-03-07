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
        
        Queue<Node> mainq = new ArrayDeque<>();
        mainq.add(root);
        mainq.add(new Node(-1));
        
        List<Integer> level = new ArrayList<>();
        
        while(mainq.size()>0){
            Node curr = mainq.remove();
            if(curr.val == -1){
                res.add(level);
                if(mainq.size()==0) return res;
                level = new ArrayList<>();
                mainq.add(new Node(-1));
            } else {
                level.add(curr.val);
                for(Node child : curr.children)
                    mainq.add(child);
            }
        }
        
        return null;
    }
}