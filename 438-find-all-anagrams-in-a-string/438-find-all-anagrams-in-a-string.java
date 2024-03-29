class Solution {
    public boolean isAnagram(int[] freq){
        for(int i=0;i<freq.length;i++){
            if(freq[i] != 0) return false;
        }
        
        return true;
    }
    
    public List<Integer> findAnagrams(String s, String p) {
        int[] freq = new int[26];
        for(int i=0;i<p.length();i++){
            freq[p.charAt(i)-'a']--;
        }
        
        List<Integer> ans = new ArrayList<>();
        
        for(int r=0;r<s.length();r++){
            freq[s.charAt(r) - 'a']++;
            int l = r - p.length();
            if(l>=0) freq[s.charAt(l) - 'a']--;
            if(isAnagram(freq)) ans.add(l+1);
        }
        
        return ans;
    }
}