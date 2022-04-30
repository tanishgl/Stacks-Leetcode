class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        int ptr2 = 1, ptr3 = 1, ptr5 = 1;
        ArrayList<Integer> ugly = new ArrayList<>();
        ugly.add(-1);
        ugly.add(1);
        
        for(int i=2;i<=n;i++){
            int a = 2 * ugly.get(ptr2);
            int b = 3 * ugly.get(ptr3);
            int c = 5 * ugly.get(ptr5);
            int min = Math.min(a, Math.min(b,c));
            ugly.add(min);
            if(min==a) ptr2++;
            if(min==b) ptr3++;
            if(min==c) ptr5++;
        }
        
        return ugly.get(n);
    }
}