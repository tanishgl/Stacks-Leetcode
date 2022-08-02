class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        HashMap<Long, Long> map[] = new HashMap[n];
        for(int i=0;i<n;i++)
            map[i] = new HashMap<>();
        
        long count = 0;
        
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                long diff = nums[i] - nums[j] * 1l;
                count += map[j].getOrDefault(diff, 0l);
                
                long oldVal = map[i].getOrDefault(diff, 0l);
                long newVal = map[j].getOrDefault(diff, 0l) + 1;
                
                map[i].put(diff, oldVal + newVal);
            }
        }
        
        return (int)count;
    }
}