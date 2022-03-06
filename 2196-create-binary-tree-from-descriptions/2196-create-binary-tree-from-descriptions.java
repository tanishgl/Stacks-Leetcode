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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> hm = new HashMap<>();
        HashMap<Integer, Integer> parents = new HashMap<>();
        TreeNode root = null;
        
        for(int i=0;i<descriptions.length;i++){
            if(hm.containsKey(descriptions[i][0])==false){
                hm.put(descriptions[i][0], new TreeNode(descriptions[i][0]));
            }
            TreeNode parent = hm.get(descriptions[i][0]);
            if(hm.containsKey(descriptions[i][1])==false){
                hm.put(descriptions[i][1], new TreeNode(descriptions[i][1]));
            }
            TreeNode child = hm.get(descriptions[i][1]);
            if(descriptions[i][2]==1){
                parent.left = child;
            } else {
                parent.right = child;
            }
            
            parents.put(child.val, parents.getOrDefault(child.val, 0) + 1);
            if(parents.containsKey(parent.val)==false){
                parents.put(parent.val, 0);
            } 
        }
        
        for(Integer node : parents.keySet()){
            if(parents.get(node)==0)
                return hm.get(node);
        }
        
        return null;
    }
}