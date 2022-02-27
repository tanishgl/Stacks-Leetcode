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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return helper(preorder, postorder, 0, preorder.length-1, 0, postorder.length-1);
    }
    
    public int find(int val, int[] arr){
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]==val)
                return i;
        }
        
        return -1;
    }
    
    public TreeNode helper(int[] pre, int[] post, int preLeft, int preRight, int postLeft, int postRight){
        if(preLeft > preRight)
            return null;
        
        if(preLeft==preRight)
            return new TreeNode(pre[preLeft]);
        
        TreeNode root = new TreeNode(pre[preLeft]);
        
        if(preLeft + 1 >= pre.length) return root;
        
        int idx = find(pre[preLeft + 1], post);
        
        int n = idx - postLeft + 1;
        
        root.left = helper(pre, post, preLeft + 1, preLeft + n, postLeft ,idx);
        root.right = helper(pre, post, preLeft + n + 1, preRight, idx + 1 ,postRight - 1);
        
        return root;
    }
}