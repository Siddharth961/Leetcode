class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int[]heights = new int[matrix[0].length];
        int[]left = new int[matrix[0].length];
        int[]right = new int[matrix[0].length];
        Stack<Integer>st = new Stack<>();
        int maxArea = 0;

        for(char[]arr : matrix){
            for(int i=0; i<arr.length; i++){
                if(arr[i]=='0') heights[i] = 0;
                else heights[i]++;
            }

            st.clear();

            for(int i=0; i<heights.length; i++){
                while(st.size()>0 && heights[st.peek()]>=heights[i]){
                    st.pop();
                }
                if(st.size()==0) left[i] = -1;
                else left[i] = st.peek();
                st.push(i);

            }

            st.clear();

            for(int i=heights.length-1; i>=0; i--){
                while(st.size()>0 && heights[st.peek()]>=heights[i]){
                    st.pop();
                }
                if(st.size()==0) right[i] = heights.length;
                else right[i] = st.peek();
                st.push(i);


                maxArea = Math.max(maxArea, heights[i]*(right[i]-left[i]-1) );
            }

            
        }

        return maxArea;
    }

    
}