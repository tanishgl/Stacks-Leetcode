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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> t1 = new ArrayList<>();
        inorder(root1, t1);
        List<Integer> t2 = new ArrayList<>();
        inorder(root2, t2);
        
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        while(i<t1.size() && j<t2.size()){
            if(t1.get(i)<=t2.get(j)){
                ans.add(t1.get(i));
                i++;
            } else {
                ans.add(t2.get(j));
                j++;
            }
        }
        
        while(i<t1.size()){
            ans.add(t1.get(i));
            i++;
        }
        
        while(j<t2.size()){
            ans.add(t2.get(j));
            j++;
        }
        
        return ans;
    }
    
    public void inorder(TreeNode node, List<Integer> ans){
        if(node == null)
            return;
        
        inorder(node.left, ans);
        
        ans.add(node.val);
        
        inorder(node.right, ans);
    }
}