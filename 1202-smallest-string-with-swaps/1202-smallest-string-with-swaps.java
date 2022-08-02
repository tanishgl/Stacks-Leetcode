class Solution {
    
    public static class DSU{
        int[] parent, rank;
        
        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            Arrays.fill(parent, -1);
            Arrays.fill(rank, 1);
        }
        
        public int find(int x){
            if(parent[x] == -1)
                return x;
            return parent[x] = find(parent[x]);
        }
        
        public void union(int x, int y){
            int px = find(x);
            int py = find(y);
            if(px == py) return;
            
            if(px <= py){
                parent[py] = px;
                rank[px] += rank[py];
            } else {
                parent[px] = py;
                rank[py] += rank[px];
            }
        }
    }
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        DSU sets = new DSU(s.length());
        
        for(List<Integer> pair : pairs){
            sets.union(pair.get(0), pair.get(1));
        }
        
        HashMap<Integer, ArrayList<Character>> mapChar = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> mapIdx = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            int parent = sets.find(i);
            if(!mapIdx.containsKey(parent)){
                mapIdx.put(parent, new ArrayList<>());
                mapChar.put(parent, new ArrayList<>());
            }
            
            mapIdx.get(parent).add(i);
            mapChar.get(parent).add(s.charAt(i));
        }
        
        char[] ans = new char[s.length()];
        
        for(Integer parent : mapIdx.keySet()){
            Collections.sort(mapChar.get(parent));
            
            for(int i=0;i<mapIdx.get(parent).size();i++){
                int idx = mapIdx.get(parent).get(i);
                char ch = mapChar.get(parent).get(i);
                ans[idx] = ch;
            }
        }
        
        return String.valueOf(ans);
    }
}