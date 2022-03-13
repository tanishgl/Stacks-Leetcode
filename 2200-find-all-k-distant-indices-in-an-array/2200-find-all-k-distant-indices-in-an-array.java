class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        
        int count = 0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] == key)
                count = k + 1;
            if(count > 0)
                res.add(i);
            count -= 1;
        }
        
        count = 0;
        
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i] == key)
                count = k + 1;
            if(count > 0)
                if(res.contains(i)==false) res.add(i);
            count -= 1;
        }
        
        Collections.sort(res);
        return res;
    }
}