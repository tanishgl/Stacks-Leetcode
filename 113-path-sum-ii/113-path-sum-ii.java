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
    List<List<Integer>> res;
    List<Integer> container;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        container = new ArrayList<>();
        helper(root, targetSum, container);
        return res;
    }
    
    public void helper(TreeNode root, int targetSum, List<Integer> container){
        if(root==null) return;
        
        container.add(root.val);
        
        if(root.left==null && root.right==null){
            if(root.val == targetSum){
                List<Integer> copy = new ArrayList<>();
                for(int val : container)
                    copy.add(val);
                res.add(copy);
            } 
            
            container.remove(container.size()-1);
            return;
        }
        
        helper(root.left, targetSum-root.val, container);
        helper(root.right, targetSum-root.val, container);
        container.remove(container.size()-1);
    }
}