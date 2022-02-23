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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leaves1 = new ArrayList<>();
        ArrayList<Integer> leaves2 = new ArrayList<>();
        
        leaf(root1, leaves1);
        leaf(root2, leaves2);
        
        if(leaves1.size()!=leaves2.size())
            return false;
        
        for(int i=0;i<leaves1.size();i++){
            if(leaves1.get(i)!=leaves2.get(i))
                return false;
        }
        
        return true;
        
        
    }
    
    public void leaf(TreeNode node, ArrayList<Integer> leaves){
        if(node==null) return;
        
        if(node.left==null && node.right==null){
            leaves.add(node.val);
            return;
        }
        
        leaf(node.left, leaves);
        leaf(node.right, leaves);
    }
}