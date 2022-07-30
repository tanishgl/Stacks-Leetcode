class Solution {
    public int lengthOfLIS(int[] nums) {
        int longest = 1;
        ArrayList<Integer> al = new ArrayList<>();
        al.add(nums[0]);
        
        for(int i=1;i<nums.length;i++){
            if(nums[i] > al.get(al.size()-1))
                al.add(nums[i]);
            else {
                int idx = binarySearch(al, nums[i]);
                al.set(idx, nums[i]);
            }
        }
        
        return al.size();
    }
    
    public int binarySearch(ArrayList<Integer> arr, int num){
        int l = 0, h = arr.size() - 1, ans = arr.size() - 1;
        
        while(l <= h){
            int mid = l + (h - l) / 2;
            if(arr.get(mid) >= num){
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return ans;
    }
}