class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<Integer> input = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            input.add(nums[i]);
        }
        //ArrayList<Integer> duplicates = new ArrayList<>();
        List<List<Integer>> result = permutations(input);
        return result;
    }
    
    public static List<List<Integer>> permutations(ArrayList<Integer> input){
        
        if(input.size()==0){
            List<List<Integer>> base = new ArrayList<>();
            ArrayList<Integer> res = new ArrayList<>();
            res.add(11);
            base.add(res);
            return base;
        }
        
        
        
        List<List<Integer>> fans = new ArrayList<>();
        for(int i=0;i<input.size();i++){
            ArrayList<Integer> inputNew = new ArrayList<>();
            for(int j=0;j<i;j++){
                inputNew.add(input.get(j));
            }
            for(int j=i+1;j<input.size();j++){
                inputNew.add(input.get(j));
            }
            List<List<Integer>> futureans = permutations(inputNew);
            
            for(int k=0;k<futureans.size();k++){
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(input.get(i));
                for(int j=0;j<futureans.get(k).size();j++){
                    ans.add(futureans.get(k).get(j));
                }
                if(ans.get(ans.size()-1)==11) ans.remove(ans.size()-1);
                if(!fans.contains(ans)){
                    fans.add(ans);
                }
            }
            
        }
        
        return fans;
    }
}