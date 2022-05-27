class Solution {
    public boolean isThree(int n) {
        int count = 2;
        
        int i = 2;
        while(i<n){
            if(n%i==0)
                count++;
            i++;
        }
        
        return count==3;
    }
}