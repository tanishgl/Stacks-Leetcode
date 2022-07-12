class Graph{
    List<Integer>[] adj;
    
    Graph(int n){
        adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
    }
    
    public void addEdge(int src, int dest){
        adj[src].add(dest);
    }
    
    public int[] BFS(int n){
        int[] incoming = new int[n];
        for(int i=0;i<n;i++){
            for(int nbr : adj[i])
                incoming[nbr]++;
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(incoming[i] == 0) q.add(i);
        }
        
        int[] ans = new int[n];
        int idx = 0;
        int visited = 0;
        
        while(q.size()>0){
            int node = q.remove();
            ans[idx++] = node;
            visited++;
            for(int nbr : adj[node]){
                incoming[nbr]--;
                if(incoming[nbr] == 0)
                    q.add(nbr);
            }
        }
        
        if(visited == n) return ans;
        else return new int[]{};
    }
}

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Graph g = new Graph(numCourses);
        for(int i=0;i<prerequisites.length;i++){
                g.addEdge(prerequisites[i][1], prerequisites[i][0]);
        }
        
        return g.BFS(numCourses);
    }
}