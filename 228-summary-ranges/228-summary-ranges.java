class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length==0) return new ArrayList<String>();
        
        List<String> res = new ArrayList<>();
        String ans = "";
        int count = 0;
        
        int[] arr = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i] = (i+1) - nums[i];
        }
        
        for(int i=0;i<nums.length;i++){
            if(i==0){
                ans = nums[i] +"";
            }
            
            if(i>0 && arr[i]!=arr[i-1]){
                if(count>1)
                    res.add(ans + "->" + nums[i-1]);
                else if (count==1)
                    res.add(ans);
                ans = nums[i] + "";
                count = 0;
            }
            
            count++;
        }
        
        if(count>1)
            res.add(ans + "->" + nums[nums.length-1]);
        else 
            res.add(ans);
        
        return res;
        
        
    }
}