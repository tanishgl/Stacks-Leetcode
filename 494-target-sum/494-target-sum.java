class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        
        if((sum - target) % 2 != 0 || target > sum) return 0;
        // System.out.println(target1);
        
        return perfectSum(nums, (sum - target) / 2);
    }
    
    public int perfectSum(int arr[], int sum) 
	{ 
        int n = arr.length;
	    int[] prev = new int[sum+1];
	    prev[0] = 1;
	    
	    for(int i=1;i<=n;i++){
	        int[] curr = new int[sum+1];
	        for(int j=0;j<=sum;j++){
	            int no = prev[j];
	            int yes = (j - arr[i-1] >= 0) ? prev[j - arr[i-1]] : 0;
	            curr[j] = no + yes;
	        }
	        
	        for(int j=0;j<prev.length;j++){
	            prev[j] = curr[j];
	        }
	    }
	    
	    return prev[sum];
	} 
}