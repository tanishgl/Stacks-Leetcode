class Solution {
    public int minDeletions(String s) {
        List<Integer> freq = new ArrayList<>();
        int[] arr = new int[26];
        
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        
        for(int i=0;i<26;i++){
            if(arr[i] > 0){
                freq.add(arr[i]);
            }
        }
        
        Collections.sort(freq, Collections.reverseOrder());
        
        int level = freq.get(0) + 1, del = 0;
        
        for(int i=0;i<freq.size();i++){
            int val = freq.get(i);
            if(level == 0){
                del += val;
            } else {
                if(level > val){
                    level = val;
                } else {
                    del += (val - level + 1);
                    level--;
                }
            }
        }
        
        return del;
    }
}