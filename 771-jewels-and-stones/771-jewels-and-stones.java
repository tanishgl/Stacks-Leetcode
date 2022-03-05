class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0;i<stones.length();i++){
            char ch = stones.charAt(i);
            hm.put(ch, hm.getOrDefault(ch,0)+1);
        }
        
        int count = 0;
        for(char ch : jewels.toCharArray()){
            count += hm.getOrDefault(ch,0);
        }
        
        return count;
    }
}