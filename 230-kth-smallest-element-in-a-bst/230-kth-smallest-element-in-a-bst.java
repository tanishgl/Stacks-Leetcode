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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        func(root,al);
        System.out.println(al);
        return al.get(k-1);
    }
    
    public void func(TreeNode root, ArrayList<Integer> al){
        if(root == null) return;
        func(root.left, al);
        al.add(root.val);
        func(root.right,al);
    }
}