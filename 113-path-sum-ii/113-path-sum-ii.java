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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(root, paths, path, targetSum);
        return paths;
    }
    
    public void helper(TreeNode root, List<List<Integer>> paths, List<Integer> path, int targetSum){
        if(root==null) return;
        
        if(root.left==null && root.right==null && root.val==targetSum){
            List<Integer> ans = new ArrayList<>();
            for(int val : path)
                ans.add(val);
            ans.add(root.val);
            paths.add(ans);
            return;
        }
        
        path.add(root.val);
            
        helper(root.left, paths, path, targetSum-root.val);
        helper(root.right, paths, path, targetSum-root.val);
        
        path.remove(path.size()-1);

    }
}