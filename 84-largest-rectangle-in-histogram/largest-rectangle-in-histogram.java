class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();

        int n = heights.length;
        int[]right = new int[n];
        int[]left = new int[n];
        int[]area = new int[n];

        //filling array for smallest element on right

        for(int i = n-1; i>=0; i--){
            while(st.size()!=0 && heights[st.peek()]>=heights[i]) st.pop();

            if(st.size()==0) right[i] = n;
            else right[i] = st.peek();

            st.push(i);
        }

        st.clear();


        //filling array for smallest element on left

        for(int i = 0; i<n; i++){
            while(st.size()!=0 && heights[st.peek()]>=heights[i]) st.pop();

            if(st.size()==0) left[i] = -1;
            else left[i] = st.peek();

            st.push(i);
        }

        

       
        // filling area array and find max area;
        int max=-1;
        for(int i=0; i<n; i++){
            area[i] = heights[i]*(right[i]-left[i]-1);
            if(area[i]>max) max = area[i];
        }

        return max;
    }
}