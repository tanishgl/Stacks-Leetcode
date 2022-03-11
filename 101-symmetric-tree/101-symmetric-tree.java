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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        ArrayList<Integer> al = new ArrayList<>();
        
        while(q.size()>0){
            int size = q.size();
            while(size-->0){
                TreeNode curr = q.remove();
                al.add(curr.val);
                if(curr.val != 101) q.add(curr.left!=null ? curr.left : new TreeNode(101));
                if(curr.val != 101) q.add(curr.right!=null ? curr.right : new TreeNode(101));
            }
            // System.out.println(al);
            if(isPallindrome(al)==false) return false;
            al = new ArrayList<>();
        }
        return true;
    }
    
    public static boolean isPallindrome(ArrayList<Integer> al){
        int i = 0, j = al.size()-1;
        while(i<j){
            if(al.get(i)!=al.get(j)) {
                System.out.println(al.get(i) + " " + i + " " + al.get(j) + " " + j);
                return false;
            } 
            i++;
            j--;
        }
        
        return true;
    }
}