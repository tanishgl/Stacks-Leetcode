class Solution {
    public int countPrefixes(String[] words, String s) {
        int count = 0;
        for(int i=0;i<words.length;i++){
            String str = words[i];
            boolean prefix = true;
            if(str.length() > s.length())
                continue;
            for(int j=0;j<str.length();j++){
                if(str.charAt(j) != s.charAt(j)){
                    prefix = false;
                    break;
                }
            }
            if(prefix)
                count++;
        }
        
        return count;
    }
}