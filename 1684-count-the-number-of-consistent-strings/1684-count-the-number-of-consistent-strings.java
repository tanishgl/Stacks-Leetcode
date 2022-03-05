class Solution {
    public int countConsistentStrings(String allow, String[] words) {
        ArrayList<Character> allowed = new ArrayList<>();
        
        for(Character ch : allow.toCharArray()){
            allowed.add(ch);
        }
        
        int count = 0;
        
        for(String str : words){
            boolean consistent = true;
            for(Character ch : str.toCharArray()){
                if(allowed.contains(ch)==false){
                    consistent = false;
                    break;
                }
            }
            
            if(consistent){
                count++;
            }
        }
        
        return count;
    }
}