class Solution {
    static class Pair {
        char ch;
        int freq;
        Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
    
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        String ans = "";
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> a.freq - b.freq);
        
        for(Character key : map.keySet()){
            minHeap.add(new Pair(key, map.get(key)));
        }
        
        while(minHeap.size() > 0){
            Pair curr = minHeap.remove();
            for(int j=1;j<=curr.freq;j++){
                ans += curr.ch;
            }
        }
        
        return new StringBuilder(ans).reverse().toString();
    }
}