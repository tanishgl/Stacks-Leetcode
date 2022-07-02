class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] vis = new boolean[graph.length];
        
        helper(0, graph.length-1, graph, path, res, vis);
        return res;
    }
    
    public void helper(int src, int dest, int[][] graph, List<Integer> path, List<List<Integer>> paths, boolean[] vis){
        if(vis[src])
            return;
        
        vis[src] = true;
        path.add(src);
        
        if(src == dest){
            paths.add(new ArrayList<>(path));
        }
        
        for(int nbr : graph[src]){
            helper(nbr, dest, graph, path, paths, vis);
        }
        
        path.remove(path.size()-1);
        vis[src] = false;
    }
}