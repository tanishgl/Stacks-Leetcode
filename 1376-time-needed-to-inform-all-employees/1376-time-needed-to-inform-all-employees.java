class Pair{
    int nbr;
    int wt;
    
    Pair(int nbr, int wt){
        this.nbr = nbr;
        this.wt = wt;
    }
}

class Graph{
    ArrayList<Pair>[] adj;
    
    Graph(int n){
          adj = new ArrayList[n];
          for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
          }
    }
        
    public void addEdge(int src, int dest, int wt){
           adj[src].add(new Pair(dest, wt));
    }
    
    public int dfs(int src, int sum){
        int maxTime = sum;
        
        for(Pair pair : adj[src]){
            maxTime = Math.max(maxTime, dfs(pair.nbr, sum + pair.wt));
        }
        
        return maxTime;
    }
}

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Graph g = new Graph(n);
        int time = 0;
        for(int i=0;i<n;i++){
            if(manager[i] == -1){
                time = informTime[i];
            } else {
                g.addEdge(manager[i], i, informTime[i]);
            }
        }
        
        return g.dfs(headID, time);
    }
}