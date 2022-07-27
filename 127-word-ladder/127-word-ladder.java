class Solution {
    
    public static class Pair{
        String str;
        int cost;
        Pair(String str, int cost){
            this.str = str;
            this.cost = cost;
        }
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        wordList.add(beginWord);
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for(String str : wordList){
            map.put(str, new HashSet<>());
        }
        
        for(int i=0;i<wordList.size();i++){
            for(int j=0;j<wordList.size();j++){
                String a = wordList.get(i);
                String b = wordList.get(j);
                if(isPossible(a,b)){
                    map.get(a).add(b);
                    map.get(b).add(a);
                }
            }
        }
        
        return bfs(beginWord, endWord, map) + 1;
    }
    
    public int bfs(String src, String dest, HashMap<String, HashSet<String>> map){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, 0));
        
        HashMap<String, Integer> vis = new HashMap<>();
        
        while(q.size()>0){
            Pair curr = q.remove();
            if(vis.containsKey(curr.str)) continue;
            vis.put(curr.str, curr.cost);
            
            for(String str : map.get(curr.str)){
                q.add(new Pair(str, curr.cost + 1));
            }
        }
        
        // System.out.println(vis);
        
        return vis.containsKey(dest) ? vis.get(dest) : -1;
    }
    
    public boolean isPossible(String x, String y){
        int count = 0;
        for(int i=0;i<x.length();i++){
            if(x.charAt(i)!=y.charAt(i))
                count++;
        }
        
        return count == 1;
    }
}