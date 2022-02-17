class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return fn(candidates, 0, target);
    }
    
    public List<List<Integer>> fn(int[] arr, int sof, int target){
        if(sof==target){
            List<List<Integer>> fans = new ArrayList<>();
            List<Integer> base = new ArrayList<>();
            base.add(-1);
            fans.add(base);
            return fans;
        }
        
        List<List<Integer>> fans = new ArrayList<>();
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]+sof<=target){
                List<List<Integer>> futans = fn(arr, sof+arr[i], target);
                for(int j=0;j<futans.size();j++){
                    List<Integer> ans = new ArrayList<>();
                    ans.add(arr[i]);
                    for(int k=0;k<futans.get(j).size();k++){
                        ans.add(futans.get(j).get(k));
                    }
                    ans.remove(new Integer(-1));
                    Collections.sort(ans);
                    if(fans.contains(ans)==false) fans.add(ans);
                }
            }
        }
        
        return fans;
    }
}