class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        return gcd(max, min);
    }
    
    public int gcd(int a, int b){
        while(a%b!=0){
            int rem = a % b;
            a = b;
            b = rem;
        }
        
        return b;
    }
}