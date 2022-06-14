class Solution {
    public List<List<String>> res;
    
    public boolean isPallindrome(String str){
        int i = 0, j = str.length() - 1;
        while(i<j){
            if(str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        
        return true;
    }
    
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        List<String> partitions = new ArrayList<>();
        
        helper(s, 0, partitions);
        return res;
    }
    
    public void helper(String str, int i, List<String> partitions){
        if(i == str.length()){
            res.add(new ArrayList<String>(partitions));
            return;
        }
        
        for(int j=i;j<str.length();j++){
            String left = str.substring(i, j+1);
            if(isPallindrome(left)){
                partitions.add(left);
                helper(str, j+1, partitions);
                partitions.remove(partitions.size() - 1);
            }
        }
    }
}