class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int[] lis = new int[security.length];
        int[] lds = new int[security.length];
        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);
        
        for(int i=1;i<security.length;i++){
            if(security[i-1] >= security[i])
                lis[i] = lis[i-1] + 1;
        }
        
        for(int i=security.length-2;i>=0;i--){
            if(security[i] <= security[i+1])
                lds[i] = lds[i+1] + 1;
        }
        
        List<Integer> res = new ArrayList<>();
        
        for(int i=time;i<security.length-time;i++){
            if(lis[i] > time && lds[i] > time)
                res.add(i);
        }
        
        return res;
        
    }
}