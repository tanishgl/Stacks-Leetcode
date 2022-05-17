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
    
    public static class Pair {
        int nodes;
        int coins;
        Pair (int nodes, int coins){
            this.nodes = nodes;
            this.coins = coins;
        }
    }
    
    public static int moves;
    
    public int distributeCoins(TreeNode root) {
        moves = 0;
        helper(root);
        return moves;
    }
    
    public Pair helper(TreeNode root){
        if(root == null) return new Pair(0,0); 
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        int coins_I_have = left.coins + right.coins + root.val;
        int coins_I_need = left.nodes + right.nodes + 1;
        moves += Math.abs(coins_I_need - coins_I_have);
        return new Pair(coins_I_need, coins_I_have);
    }
}