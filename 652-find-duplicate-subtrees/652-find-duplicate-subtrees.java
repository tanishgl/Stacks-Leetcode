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
    HashMap<String, Integer> hm = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root == null) return result;
        preSerialize(root);
        return result;
    }
    
    public String preSerialize(TreeNode root){
        if(root == null) return "#,";
        
        String serial = root.val + "," + preSerialize(root.left) + preSerialize(root.right);
        
        if(hm.containsKey(serial) == true && hm.get(serial) == 1){
            result.add(root);
        }
        
        hm.put(serial, hm.getOrDefault(serial, 0) + 1);
        
        return serial;
    }
}