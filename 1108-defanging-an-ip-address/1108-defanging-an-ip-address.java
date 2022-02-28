class Solution {
    public String defangIPaddr(String address) {
        String ans = "";
        for(int i=0;i<address.length()-1;i++){
            char ch = address.charAt(i+1);
            if(ch=='.'){
                ans += address.charAt(i) + "[.]";
                i++;
            } else {
                ans += address.charAt(i);
            }
        }
        
        ans += address.charAt(address.length()-1);
        
        return ans;
    }
}