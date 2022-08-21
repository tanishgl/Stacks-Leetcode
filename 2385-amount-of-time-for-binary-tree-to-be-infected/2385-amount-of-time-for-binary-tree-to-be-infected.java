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
    
    static class Pair{
        int val;
        int time;
        Pair(int val, int time){
            this.val = val;
            this.time = time;
        }
    }
    
    public static HashMap<Integer, ArrayList<Integer>> map;
    public static HashMap<Integer, Boolean> vis;
    public static int size;
    public static int infect;
    
    public int amountOfTime(TreeNode root, int start) {
        map = new HashMap<>();
        vis = new HashMap<>();
        size = DFS(root, 0);
        infect = 0;
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(start, 0));
        
        while(q.size()>0){
            Pair node = q.remove();
            if(vis.get(node.val)) continue;
            vis.put(node.val, true);
            infect = Math.max(infect, node.time);
            for(Integer nbr : map.get(node.val)){
                q.add(new Pair(nbr, node.time + 1));
            }
        }
        
        return infect;
    }
    
    public int DFS(TreeNode root, int par){
        if(root == null) return 0;
        map.put(root.val, new ArrayList<>());
        vis.put(root.val, false);
        // Parent -> Child
        if(par != 0) map.get(par).add(root.val);
        // Child -> Parent
        if(par != 0) map.get(root.val).add(par);
        return size = DFS(root.left, root.val) + DFS(root.right, root.val) + 1;
    }
}