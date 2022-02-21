class Solution {
    public boolean areNumbersAscending(String s) {
        String[] arr = s.split(" ");
        List<Integer> al = new ArrayList<>();
        
        for(String val : arr){
            char ch = val.charAt(0);
            
            if(ch>='0' && ch<='9'){
                al.add(Integer.parseInt(val));
            }
        }
        
        
        for(int i=al.size()-2;i>=0;i--){
            if(al.get(i)>=al.get(i+1))
                return false;
        }
        
        return true;
    }
}