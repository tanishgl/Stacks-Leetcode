class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i=1;i<nums.length;i++)
            prefix[i] = nums[i] + prefix[i-1];
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);
        
        int count = 0;
        
        for(int i=0;i<prefix.length;i++){
            int desire = prefix[i] - k;
            int freq = hm.getOrDefault(desire, 0);
            count += freq;
            hm.put(prefix[i], hm.getOrDefault(prefix[i],0)+1);
        }
        
        return count;
    }
}