class Solution {
    public boolean canCross(int[] stones) {
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        List<Integer> points = new ArrayList<>();
        for(int val : stones)
            points.add(val);
        return rec(points, 0, -1, stones[stones.length-1], map) == 1;
    }
    
    public int rec(List<Integer> points, int pos, int prev, int dest, HashMap<List<Integer>, Integer> map){
        if(pos == prev)
            return 0;
        if(pos < 0 || pos > dest)
            return 0;
        if(!points.contains(pos))
            return 0;
        if(pos == dest)
            return 1;
        List<Integer> xy = new ArrayList<>();
        xy.add(pos);
        xy.add(prev);
        if(map.containsKey(xy))
            return map.get(xy);
        
        int ans = 0;
        
        if(pos == 0){
            ans = rec(points, pos + 1, pos, dest, map);
            if(ans == 1) return 1;
        } else {
            int k = pos - prev;
            ans = rec(points, pos + k - 1, pos, dest, map);
            if(ans == 1) return 1;
            ans = rec(points, pos + k, pos, dest, map);
            if(ans == 1) return 1;
            ans = rec(points, pos + k + 1, pos, dest, map);
            if(ans == 1) return 1;
        }
        
        map.put(xy, 0);
        return 0;
    }
}