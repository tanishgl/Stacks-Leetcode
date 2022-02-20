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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelp(inorder, postorder, 0, inorder.length-1, postorder.length-1);
    }
    
    public TreeNode buildTreeHelp(int[] inorder, int[] postorder, int il, int ir, int p){
        if(il>ir) return null;
        
        TreeNode root = new TreeNode(postorder[p]);
        
        int index = 0;
        for(int i=il;i<=ir;i++){
            if(inorder[i]==root.val){
                index = i;
                break;
            }
        }
        
        root.left = buildTreeHelp(inorder, postorder, il, index - 1, p - 1 - (ir - index));
        
        root.right = buildTreeHelp(inorder, postorder, index + 1, ir, p - 1);
        
        return root;
    }
}