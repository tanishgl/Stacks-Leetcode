/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        
        Stack<TreeNode> mains = new Stack<>();
        mains.push(root);
        Stack<TreeNode> childs = new Stack<>();
        
        List<Integer> level = new ArrayList<>();
        int l = 0;
        
        while(mains.size()>0){
            TreeNode curr = mains.pop();
            level.add(curr.val);
            
            //Push it's children into children stack.
            if(l%2==0){
                if(curr.left!=null) childs.push(curr.left);
                if(curr.right!=null) childs.push(curr.right);
            } else {
                if(curr.right!=null) childs.push(curr.right);
                if(curr.left!=null) childs.push(curr.left);
            }
            
            if(mains.size()==0){
                res.add(level);
                level = new ArrayList<>();
                l++;
                mains = childs;
                childs = new Stack<>();
            }
        }
        
        return res;
    }
}