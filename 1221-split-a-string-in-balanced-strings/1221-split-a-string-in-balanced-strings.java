class Solution {
    public int balancedStringSplit(String s) {
        int var = 0, ans = 0;
        char state = 'l';
        
        for(Character ch : s.toCharArray()){
            if(var==0){
                state = ch;
                var++;
            } else {
                if(ch==state){
                    var++;
                } else {
                    var--;
                }
            }
            
            if(var==0){
                ans++;
            }
        }
        
        return ans;
    }
}