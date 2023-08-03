class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Stack<Integer> st = new Stack<>();
        int[]nger = new int[nums.length];

        for(int i = nger.length-1; i>=0; i-- ){
            while(st.size()!=0 && nums[st.peek()]<nums[i]) st.pop();
            if(st.size()==0) nger[i] = nums.length;
            else nger[i] = st.peek();
            st.push(i);
        }

        int[]ans  = new int[nums.length-k+1];
        int j=0;
        for(int i=0; i<ans.length; i++){
         if(j<i)j=i;
         while(nger[j]<i+k) j=nger[j];
         ans[i] = nums[j];
        }
        
        return ans;
    }
}