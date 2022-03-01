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
    int totalSum = 0;
    HashMap<Integer, Integer> hm;
    
    public int pathSum(TreeNode root, int targetSum) {
        hm = new HashMap<>();
        hm.put(0,1);
        return helper(root, targetSum);
    }
    
    public int helper(TreeNode root, int targetSum){
        if(root==null) return 0;
        
        totalSum += root.val;
        
        int count = hm.getOrDefault(totalSum - targetSum, 0);
        hm.put(totalSum, hm.getOrDefault(totalSum, 0) + 1);
        
        count += helper(root.left, targetSum) + helper(root.right, targetSum);
        
        hm.put(totalSum, hm.getOrDefault(totalSum, 0) - 1);
        
        totalSum -= root.val;
        
        return count;
    }
}