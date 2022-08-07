class Solution {
    
    public static int[] disc;
    public static int[] low;
    public static int time = 0;
    public static List<List<Integer>> bridges;
    
    public void DFS(int src, int parent, ArrayList<Integer>[] adj){
        disc[src] = low[src] = time++;
        
        for(Integer nbr : adj[src]){
            if(nbr == parent) 
                continue;
            else if (disc[nbr] >= 0){
                // Back Edge
                low[src] = Math.min(low[src], disc[nbr]);
            } else {
                // Tree Edge or Unvisited Neighbour
                DFS(nbr, src, adj);
                if(low[nbr] > disc[src]){
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(src);
                    bridge.add(nbr);
                    bridges.add(bridge);
                }
                low[src] = Math.min(low[src], low[nbr]);
            }
        }
    }
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        disc = new int[n];
        low = new int[n];
        Arrays.fill(disc, -1);  
        bridges = new ArrayList<>();
        
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        
        for(List<Integer> edge : connections){
            adj[edge.get(0)].add(edge.get(1));
            adj[edge.get(1)].add(edge.get(0));
        }
        
        DFS(0, -1, adj);
        
        return bridges;
    }
}