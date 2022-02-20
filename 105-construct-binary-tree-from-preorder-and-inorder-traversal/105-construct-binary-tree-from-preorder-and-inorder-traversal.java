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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //Root node is at preorder[0].
        return buildTreeHelp(preorder, inorder, 0, 0, inorder.length-1);
    }
    
    public TreeNode buildTreeHelp(int[] preorder, int[] inorder, int pl, int il, int ir) {
        if(il > ir) return null;
        //Root node is at preorder[0].
        TreeNode root = new TreeNode(preorder[pl]);
        
        //Find root node's index in inorder.
        int index = 0;
        for(int i=il;i<=ir;i++){
            if(inorder[i]==root.val){
                index = i;
                break;
            }
        }
        
        //No. of nodes in the left.
        int leftNodes = index - il;
        int rightNodes = ir - index;
        
        //Figure out the root's left and right range.
        TreeNode left = buildTreeHelp(preorder, inorder, pl+1, il, index-1);
        
        TreeNode right = buildTreeHelp(preorder, inorder, pl+leftNodes+1, index+1, ir);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
}