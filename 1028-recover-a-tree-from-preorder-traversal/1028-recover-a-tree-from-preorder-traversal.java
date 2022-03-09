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
    public static class Pair{
        TreeNode node;
        char state;
        int level;
        
        Pair(TreeNode node, int d){
            this.node = node;
            state = 'l';
            level = d;
        }
    }
    
    public TreeNode recoverFromPreorder(String traversal) {
        TreeNode root = null;
        Stack<Pair> st = new Stack<>();
        int count = 0;
        
        for(int i=0;i<traversal.length();i++) {
            // System.out.println(count);
            char ch = traversal.charAt(i);
            if(ch>='0' && ch<='9'){
                int num = ch - '0';
                while(i+1 < traversal.length() && traversal.charAt(i+1) != '-'){
                    i++;
                    num = (num*10) + (traversal.charAt(i) - '0');
                }
                
                TreeNode node = new TreeNode(num);
                Pair curr = new Pair(node, count);
                if(st.size()==0){
                    root = node;
                } else {
                    if(st.peek().state=='l'){
                        st.peek().node.left = node;
                    } else {
                        st.peek().node.right = node;
                    }
                }
                
                st.push(curr);
                
            } else {
                //char is a hyphen i.e. "-".
                int cnt = 1;
                while(i+1 < traversal.length() && traversal.charAt(i+1)=='-'){
                    i++;
                    cnt++;
                }
                
                if(cnt==count){
                    st.pop();
                    st.peek().state = 'r';
                } else if (cnt < count){
                    while(st.size()>0 && st.peek().level >= cnt){
                        st.pop();
                    }
                    st.peek().state = 'r';
                }
                
                count = cnt;
            }
        }
        
        return root;
    }
}