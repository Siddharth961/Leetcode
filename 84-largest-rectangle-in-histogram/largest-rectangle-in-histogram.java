class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        
        Stack<Integer>st = new Stack<>();

        int[]left = new int[n];
        int[]right = new int[n];

        for(int i=0; i<n; i++){

            while(st.size()>0 && heights[st.peek()] >= heights[i] ){
                st.pop();
            }

            if(st.size()==0) left[i] = -1;
            else left[i] = st.peek();
            st.push(i);
        }

        st.clear();

        for(int i=n-1; i>=0; i--){

            while(st.size()>0 && heights[st.peek()] >= heights[i] ){
                st.pop();
            }

            if(st.size()==0) right[i] = n;
            else right[i] = st.peek();
            st.push(i);
        }

        

        int ans = -1;

        for(int i=0; i<n; i++){
            ans  = Math.max(ans, heights[i]*(right[i]-left[i]-1) );

        }

        return ans;
    }
}