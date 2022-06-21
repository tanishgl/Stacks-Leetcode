class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        
        // Unique Keys
        HashMap<Integer, Boolean> map = new HashMap<>();
        
        // All are potential sequence starters.
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], true);
        }
        
        // Remove elements which cannot become a starter.
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i] - 1)){
                // Hence we cannot start the sequence.
                // We will join the previous sequence.
                map.put(nums[i], false);
            }
        }
        
        int maxLen = 1;
        for(int i=0;i<nums.length;i++){
            if(!map.get(nums[i]))
                continue;
            int curr = 1;
            for(int j=nums[i]+1; map.containsKey(j); j++){
                curr++;
            }
            
            maxLen = Math.max(maxLen, curr);
        }
        
        return maxLen;
    }
}