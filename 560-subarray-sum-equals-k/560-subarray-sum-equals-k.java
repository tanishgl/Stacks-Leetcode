class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        
        hm.put(0,1);
        
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        
        for(int i=0;i<prefix.length;i++){
            int target = prefix[i] - k;
            if(hm.containsKey(target)==true){
                count += hm.get(target);
            }
            hm.put(prefix[i], hm.getOrDefault(prefix[i],0)+1);
        }
        
        return count;
    }
}