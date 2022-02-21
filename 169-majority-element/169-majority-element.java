class Solution {
    public int majorityElement(int[] nums) {
        int n = (nums.length)/2;
        Arrays.sort(nums);
        int count = 0;
        
        for(int i=0;i<nums.length;i++){
            if(i==0 || nums[i]!=nums[i-1]){
                if(i>0 && count>n){
                    return nums[i-1];
                }
                
                count = 0;
            }
            count++;
        }
        
        if(count>n)
            return nums[nums.length-1];
        
        return 0;
    }
}