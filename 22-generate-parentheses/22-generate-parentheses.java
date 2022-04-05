class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        rec(n, n, "", ans);
        return ans;
    }
    
    public void rec(int o, int c, String sof, List<String> res){
        if(o==c && o==0){
            res.add(sof);
            return;
        }
        
        if(o>c) return;
        
        //Either opening comes.
        if(o>0) rec(o-1, c, sof+"(", res);
        
        //Either close comes.
        if(c>0) rec(o, c-1, sof+")", res);
    }
}