class Solution {
    public int lengthOfLIS(int[] nums) {
        // Binary Search algorithm.
        List<Integer> subs = new ArrayList<>();
        subs.add(nums[0]);
        
        for(int i=1;i<nums.length;i++){
            if(nums[i] > subs.get(subs.size()-1)){
                subs.add(nums[i]);
            } else {
                int idx = lowerBound(subs, nums[i]);
                subs.set(idx, nums[i]);
            }
        }
        
        return subs.size();
    }
    
    public int lowerBound(List<Integer> arr, int target){
        int lo = 0, hi = arr.size()-1;
        int ans = 0;
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(arr.get(mid) >= target){
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return ans;
    }
}