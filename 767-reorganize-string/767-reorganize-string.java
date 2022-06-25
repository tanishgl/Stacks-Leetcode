class Solution {
    static class Pair{
        char ch;
        int fr;
        Pair(char ch, int fr){
            this.ch = ch;
            this.fr = fr;
        }
    }
    
    public String reorganizeString(String s) {
        if(s.length() == 1) return s;
        HashMap<Character, Integer> map = new HashMap<>(); 
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.fr != b.fr ? b.fr - a.fr : a.ch - b.ch);
        
        for(char key : map.keySet()){
            pq.add(new Pair(key, map.get(key)));
        }
        
        StringBuilder sb = new StringBuilder();
        while(pq.size()>0){
            Pair odd = pq.remove();
            sb.append(odd.ch);
            odd.fr--;
            
            if(pq.size() == 0 && odd.fr > 0)
                return "";
            
            if(pq.size() > 0){
                Pair even = pq.remove();
                sb.append(even.ch);
                even.fr--;
                
                if(even.fr > 0)
                pq.add(even);
            }
            
            if(odd.fr > 0)
                pq.add(odd);
                
        }
        
        return sb.toString();
    }
}