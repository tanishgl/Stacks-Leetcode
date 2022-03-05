class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for(String str : operations){
            char ch = str.charAt(1);
            if(ch=='+'){
                ans++;
            } else if (ch=='-'){
                ans--;
            }
        }
        
        return ans;
    }
}