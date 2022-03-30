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
    public boolean findTarget(TreeNode root, int target) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        int i=0, j=arr.size()-1;
        while(i<j){
            if(arr.get(i)+arr.get(j)==target){
                return true;
            } else if (arr.get(i)+arr.get(j)>target){
                j--;
              } else if (arr.get(i)+arr.get(j)<target){
                i++;
              }
        }
        
        return false;
    }
    
    public void inorder(TreeNode root, ArrayList<Integer> al){
        if(root==null) return;
        inorder(root.left,al);
        al.add(root.val);
        inorder(root.right,al);
    }
}