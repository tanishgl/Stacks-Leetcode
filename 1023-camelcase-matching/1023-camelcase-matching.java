class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        
        for(int i=0;i<queries.length;i++){
            if(queries[i].length() < pattern.length()){
                ans.add(false);
            } else {
                ans.add(match(queries[i], pattern));
            }
        }
        
        return ans;
    }
    
    public boolean match(String str, String pattern){
        int i = 0, j = 0;
        while(i < str.length()){
            char ch1 = str.charAt(i);
            char ch2 = (j < pattern.length()) ? pattern.charAt(j) : '0';
            if(ch1 == ch2){
                j++;
            } else {
                if(Character.isUpperCase(ch1))
                    return false;
            }
            i++;
        }
        
        if(j < pattern.length())
            return false;
        
        return true;
    }
}