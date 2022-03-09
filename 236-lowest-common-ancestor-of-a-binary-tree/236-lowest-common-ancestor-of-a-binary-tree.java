/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.left == q || p.right == q) return p;
        if(q.left == p || q.right == p) return q;
        ArrayList<Integer> a1 = n2rpath(root, p.val);
        ArrayList<Integer> a2 = n2rpath(root, q.val);
        
        int lca = 0;
        
        int i = a1.size()-1, j = a2.size()-1;
        
        while(i>=0 && j>=0 && a1.get(i)==a2.get(j)){
            lca = a1.get(i);
            i--;
            j--;
        }
        
        return new TreeNode(lca);
    }
    
    public ArrayList<Integer> n2rpath(TreeNode root, int data){
        if(root.val == data){
            ArrayList<Integer> base = new ArrayList<>();
            base.add(data);
            return base;
        }
        
        if(root.left!=null){
            ArrayList<Integer> res = n2rpath(root.left, data);
            if(res.size()>0){
                res.add(root.val);
                return res;
            }
        } 
        
        if(root.right!=null){
            ArrayList<Integer> res = n2rpath(root.right, data);
            if(res.size()>0){
                res.add(root.val);
                return res;
            }
        }
        
        return new ArrayList<>();
    }
}