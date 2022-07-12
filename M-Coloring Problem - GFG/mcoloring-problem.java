// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}
// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        return helper(0, graph, m, vis);
    }
    
    public boolean helper(int idx, boolean[][] graph, int color, int[] vis){
        if(idx == graph.length){
            return true;
        }
        
        for(int c=0;c<color;c++){
            if(canBeColored(idx, graph, c, vis)){
                vis[idx] = c;
                if(helper(idx + 1, graph, color, vis)) return true;
                vis[idx] = -1;
            }
        }
        
        return false;
    }
    
    public boolean canBeColored(int node, boolean[][] graph, int color, int[] vis){
        for(int nbr=0;nbr<graph.length;nbr++){
            if(graph[node][nbr] == true && vis[nbr] == color) return false;
        }
        return true;
    }
}