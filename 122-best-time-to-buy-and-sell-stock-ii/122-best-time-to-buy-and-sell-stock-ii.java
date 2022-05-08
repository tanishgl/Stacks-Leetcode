class Solution {
    public int maxProfit(int[] prices) {
//         Stack<Integer> st = new Stack<>();
//         st.push(prices[0]);
//         int res = 0;
        
//         for(int i=1;i<prices.length;i++){
//             int p = Integer.MIN_VALUE;
//             while(st.size()>0 && prices[i]>st.peek()){
//                 p = Math.max(p, prices[i]-st.pop());
//             }
//            if(p>0)
//                res += p;
//             st.push(prices[i]);
//         }
        
//         return res;
        int buying = prices[0];
        int profit = 0;
        
        for(int i=0;i<prices.length;i++){
            if(buying < prices[i]){
                profit += prices[i] - buying;
            }
            buying = prices[i];
        }
        return profit;
    }
}