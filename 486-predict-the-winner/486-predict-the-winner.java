class Solution {
    public int helper(int left, int right, int[] arr){
        if(left > right){
            return 0;
        }
        
        if(left == right)
            return arr[left];
        
        int c1 = helper(left + 2, right, arr);
        int c2 = helper(left + 1, right -1, arr);
        int c3 = helper(left, right - 2, arr);
        
        return Math.max(arr[left] + Math.min(c1, c2), arr[right] + Math.min(c2, c3));
    }
    
    public boolean PredictTheWinner(int[] nums) {
        int A = helper(0, nums.length-1, nums);
        
        int total = 0;
        for(int val : nums){
            total += val;
        }
        
        int B = total - A;
        
        return A >= B;
    }
}