class Solution {
    public int findKthLargest(int[] nums, int k) {
        return helper(nums, 0, nums.length - 1, k);
    }
    
    public int partition(int[] nums, int lo, int hi, int pivot){
        int i = lo, j = lo;
        while(i <= hi){
            if(nums[i] >= pivot){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            } else {
                i++;
            }
        }
        
        return (j - 1);
    }
    
    public int helper(int[] nums, int lo, int hi, int k){
        int idx = partition(nums, lo, hi, nums[hi]);
        
        if(idx == k - 1)
            return nums[idx];
        else if (idx < k - 1)
            return helper(nums, idx + 1, hi, k);
        else if (idx > k - 1)
            return helper(nums, lo, idx - 1, k);
        
        return -1;
    }
}