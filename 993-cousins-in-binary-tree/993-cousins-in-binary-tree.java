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
    class Pair{
        TreeNode node;
        int parent;
        
        Pair(TreeNode node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root.val == x || root.val == y) return false;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, -1));
        int level = 0;
        
        int[][] parent = new int[2][2];
        
        while(q.size()>0){
            int size = q.size();
            while(size-->0){
                Pair curr = q.remove();
                if(curr.node.val == x){
                    parent[0][0] = level;
                    parent[0][1] = curr.parent;
                } else if (curr.node.val == y){
                    parent[1][0] = level;
                    parent[1][1] = curr.parent;
                }
                
                if(curr.node.left != null) q.add(new Pair(curr.node.left, curr.node.val));
                if(curr.node.right != null) q.add(new Pair(curr.node.right, curr.node.val));
            }
            level++;
        }
        
        if(parent[0][0]!=parent[1][0]) return false;
        if(parent[0][1] == parent[1][1]) return false;
        
        return true;
    }
}