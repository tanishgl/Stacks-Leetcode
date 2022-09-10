class Solution {
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        DFS(0, res, ans, graph);
        return res;
    }
    
    public void DFS(int src, List<List<Integer>> res, List<Integer> ans, int[][] graph){
        if(src < graph.length - 1) ans.add(src);
        
        if(src == graph.length-1){
            ArrayList<Integer> base = new ArrayList<>(ans);
            base.add(src);
            res.add(base);
            return;
        }
        
        for(int nbr : graph[src]){
            DFS(nbr, res, ans, graph);
        }
        
        ans.remove(ans.size()-1);
    }
}