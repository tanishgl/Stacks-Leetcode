class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        
        int idx = 0;
        if(ruleKey.equals("color"))
            idx = 1;
        else if (ruleKey.equals("name"))
            idx = 2;
        
        int count = 0;
        
        for(List<String> al : items){
            if(al.get(idx).equals(ruleValue))
                count++;
        }
        
        return count;
        
    }
}