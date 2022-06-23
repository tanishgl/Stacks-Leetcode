class Solution {
    
    static class Pair {
        String str;
        int freq;
        Pair(String str, int freq){
            this.str = str;
            this.freq = freq;
        }
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> (a.freq != b.freq) ? a.freq - b.freq : b.str.compareTo(a.str));
        
        for(String key : map.keySet()){
            minHeap.add(new Pair(key, map.get(key)));
            if(minHeap.size() > k)
                minHeap.remove();
        }
        
        List<String> res = new ArrayList<>();
        
        while(k-->0){
            // System.out.println("Freq of " + minHeap.peek().str + " is " + minHeap.peek().freq);
            res.add(minHeap.remove().str);
        }
        
        Collections.reverse(res);
        return res;
        
    }
}