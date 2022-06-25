class Solution {
    public boolean checkPossibility(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int lis = 1;
        
        for(int i=0;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[j] <= nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            lis = Math.max(lis, dp[i]);
        }
        
        return nums.length - lis <= 1;
    }
}


/* Wrong Code */

//         int falls = 0;
//         for(int i=0;i<nums.length;i++){
//             if(i>0 && nums[i] < nums[i-1])
//                 falls++;
//             if(falls > 1)
//                 return false;
//         }
        
//         return true;
//         Test Case :- [3,4,2,3]