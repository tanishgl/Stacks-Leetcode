class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> res = new ArrayList<>();
        
        //Base case.
        List<String> base = new ArrayList<>();
        base.add("");
        res.add(base);
        
        //Range of words.
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(String str : wordDict){
            min = Math.min(min, str.length());
            max = Math.max(max, str.length());
        }
        
        //iteration.
        
        for(int i=1;i<=s.length();i++){
            List<String> ans = new ArrayList<>();
            for(int j=min;j<=max;j++){
                if(i-j >= 0){
                    String sub = s.substring(i-j, i);
                    if(wordDict.contains(sub) && res.get(i-j).size()>0){
                        for(String str : res.get(i-j)){
                            if(str.length()>0)
                                ans.add(str + " " + sub);
                            else 
                                ans.add(sub);
                        }
                    }
                }
            }
            res.add(ans);
        }
        
        return res.get(res.size()-1);
    }
}