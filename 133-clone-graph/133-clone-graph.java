/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        if(node.neighbors.size() == 0) return new Node(node.val);
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        boolean[] vis = new boolean[101];
        DFS(node, vis, map);
        // System.out.println(map);
        
        HashMap<Integer, Node> map1 = new HashMap<>();
        for(Integer key : map.keySet()){
            map1.put(key, new Node(key));
        }
        
        for(Integer key : map1.keySet()){
            Node nx = map1.get(key);
            for(Integer ig : map.get(key)){
                nx.neighbors.add(map1.get(ig));
            }
        }
        
        return map1.get(node.val);
    }
    
    public void DFS(Node node, boolean[] vis, HashMap<Integer, ArrayList<Integer>> map){
        if(vis[node.val]) return;
        
        vis[node.val] = true;
        
        if(!map.containsKey(node.val)) {
            ArrayList<Integer> al = new ArrayList<>();
            map.put(node.val, al);  
        } 
        
        for(Node nbr : node.neighbors){
            map.get(node.val).add(nbr.val);
        }
        
        for(Node nbr : node.neighbors){
            DFS(nbr, vis, map);
        }
    }
}