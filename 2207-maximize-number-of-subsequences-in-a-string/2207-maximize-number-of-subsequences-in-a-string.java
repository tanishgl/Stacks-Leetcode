class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        List<Integer> q1 = new ArrayList<>();
        List<Integer> q2 = new ArrayList<>();
        
        char ch1 = pattern.charAt(0);
        char ch2 = pattern.charAt(1);
        
        for(int i=0;i<text.length();i++){
            char ch = text.charAt(i);
            if(ch==ch1){
                q1.add(i);
            } else if (ch==ch2){
                q2.add(i);
            }
        }
        
        if(ch1==ch2){
            return ((long)((long)q1.size()*(long)(q1.size()-1))/2)+q1.size();
        }
        
        System.out.println(q1);
        System.out.println(q2);
        
        // if(q1.size()==q2.size()){
        //     return q1.size() * (q1.size()+1);
        // }
        
        int i = 0, j = 0;
        long count = 0;
        while(i<q1.size() && j<q2.size()){
            if(q1.get(i) < q2.get(j)){
                count += q2.size() - j;
                i++;
            } else {
                j++;
            }
        }
        
        if(i<q1.size()){
            while(i<q1.size()){
                i++;
            }
        }
        
        if(j<q2.size()){
            while(j<q2.size()){
                j++;
            }
        }
        
        if(q2.size()==0){
            count += q1.size();
        } else if (q1.size()==0){
            count += q2.size();
        } else if (q1.size() <= q2.size()){
            count += q2.size();
        } else if (q1.size() > q2.size()){
            count += i;
        }
        
        return count;
        
        
    }
}