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
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null){
            return new ArrayList<String>();
        }
        
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        List<String> fans = new ArrayList<>();
        
        if(left.size()>0){
            for(String ans : left){
                fans.add(root.val + "->" + ans);
            }
            
        }
        
        if(right.size()>0){
            for(String ans : right){
                fans.add(root.val + "->" + ans);
            }
        }
        
        if(left.size()==0 && right.size()==0){
            fans.add(root.val+"");
        }
        
        return fans;
    }
}