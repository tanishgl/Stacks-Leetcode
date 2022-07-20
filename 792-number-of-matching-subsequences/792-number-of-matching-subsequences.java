class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, ArrayList<String>> map = new HashMap<>();
        
        for(char ch = 'a'; ch <= 'z'; ch++){
            map.put(ch, new ArrayList<>());
        }
        
        for(int i=0;i<words.length;i++){
            map.get(words[i].charAt(0)).add(words[i]);
        }
        
        int count = 0;
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            for(int j=map.get(ch).size()-1;j>=0;j--){
                String str = map.get(ch).get(j);
                if(str.length() == 1){
                    count++;
                } else {
                    map.get(str.charAt(1)).add(str.substring(1));
                }
                map.get(ch).remove(str);
            }
        }
        
        return count;
    }
}