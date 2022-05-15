class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        rec(0, nums, ans, res);
        return res;
    }
    
    public void rec(int idx, int[] nums, List<Integer> ans, List<List<Integer>> res){
        if(idx == nums.length){
            // System.out.println(ans);
            List<Integer> base = new ArrayList<>(ans);
            res.add(base);
            return;
        }
        
        //Either I will come.
        ans.add(nums[idx]);
        rec(idx + 1, nums, ans, res);
        
        //Or I will not come.
        ans.remove(ans.size()-1);
        rec(idx + 1, nums, ans, res);
    }
}