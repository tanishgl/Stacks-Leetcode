class Solution {
    public boolean checkString(String s) {
        //Calculate first occurence of 'b'.
        
        int idx = -1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='b'){
                idx = i;
                break;
            }
        }
        
        if(idx==-1) return true;
        
        for(int i=idx+1;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='a')
                return false;
        }
        
        return true;
    }
}