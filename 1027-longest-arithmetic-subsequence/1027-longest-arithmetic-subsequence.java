class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer>[] map = new HashMap[n];
        for(int i=0;i<n;i++)
            map[i] = new HashMap<>();
        int lis = 1;
        
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                int diff = nums[i] - nums[j];
                int oldVal = map[i].getOrDefault(diff, 0);
                int newVal = map[j].containsKey(diff) ? map[j].get(diff) + 1 : 1;
                map[i].put(diff, Math.max(oldVal, newVal));
                lis = Math.max(lis, map[i].get(diff));
            }
        }
        
        return lis + 1;
    }
}