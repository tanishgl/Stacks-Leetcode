class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, maxLen = 0, currLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int idx = 0; idx < s.length(); idx++){
            char ch = s.charAt(idx);
            if(map.containsKey(ch) && map.get(ch) >= i && map.get(ch) <= j){
                i = map.get(ch) + 1;
                j++;
                currLen = j - i;
            } else {
                currLen++;
                j++;
            }
            
            maxLen = Math.max(maxLen, currLen);
            map.put(ch, idx);
        }
        
        return maxLen;
    }
}