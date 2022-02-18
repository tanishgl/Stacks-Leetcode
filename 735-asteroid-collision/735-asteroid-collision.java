class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        
        
        for(int val : arr){
            
            boolean destroy = false;
            
            if(val<0){
                while(st.size()>0 && st.peek()>0){
                    if(st.peek() < -val){
                        st.pop();
                    } else if (st.peek() > -val){
                        destroy = true;
                        break;
                    } else {
                        st.pop();
                        destroy = true;
                        break;
                    }
                }
                
                if(!destroy){
                    st.push(val);
                }
            } else {
                st.push(val);
            }
            
        }
        
        int[] ans = new int[st.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}