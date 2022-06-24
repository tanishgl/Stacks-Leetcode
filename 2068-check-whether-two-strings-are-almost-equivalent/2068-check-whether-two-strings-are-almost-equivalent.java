class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        for(int i=0;i<word1.length();i++){
            f1[word1.charAt(i)-'a']++;
        }
        
        for(int i=0;i<word2.length();i++){
            f2[word2.charAt(i)-'a']++;
        }
        
        for(int i=0;i<26;i++){
            if(Math.abs(f1[i]-f2[i]) > 3)
                return false;
        }
        
        return true;
    }
}