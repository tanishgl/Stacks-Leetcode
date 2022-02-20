/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "null,";
        }
        
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }
    
    public static class Pair{
        char state;
        TreeNode node;
        
        Pair(TreeNode node){
            this.state = 'l';
            this.node = node;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null,")==true) return null;
        String[] tokens = data.split(","); 
        TreeNode root = null;
        Stack<Pair> st = new Stack<>();
        
        for(String token : tokens){
            if(token.equals("null")==true){
                if(st.peek().state=='l')
                    st.peek().state = 'r';
                else 
                    st.pop();
            } else {
                TreeNode temp = new TreeNode(Integer.parseInt(token));
                if(st.empty()==true){
                    root = temp;
                } else {
                    if(st.peek().state=='l'){
                        st.peek().node.left = temp;
                        st.peek().state = 'r';
                    } else {
                        st.peek().node.right = temp;
                        st.pop();
                    }
                }
                
                st.push(new Pair(temp));
            }
            
            
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));