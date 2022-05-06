class Solution {
    public static class Node{
        Node left;
        Node right;
    }
    
    public void insert(Node root, int num){
        for(int i=31;i>=0;i--){
            int bit = num & (1<<i);
            
            if(bit==0){
                //Left child.
                if(root.left==null)
                    root.left = new Node();
                root = root.left;
            } else {
                //left child
                if(root.right==null)
                    root.right = new Node();
                root = root.right;
            }
        }
    }
    
    public int search(Node root, int num){
        int maXor = 0;
        
        for(int i=31;i>=0;i--){
            int bit = num & (1<<i);
            
            if(bit==0){
                if(root.right != null){
                    root = root.right;
                    maXor = maXor | (1 << i);
                } else {
                    root = root.left;
                }
            } else {
                if(root.left != null){
                    root = root.left;
                    maXor = maXor | (1 << i);
                } else {
                    root = root.right;
                }
            }
        }
        
        return maXor;
    }
    
    public int findMaximumXOR(int[] nums) {
        Node root = new Node();
        
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            insert(root, nums[i]);
            ans = Math.max(ans, search(root, nums[i]));
        }
        
        return ans;
    }
}