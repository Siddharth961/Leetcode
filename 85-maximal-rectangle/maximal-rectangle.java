class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int[]heights = new int[matrix[0].length+1];
        int[]left = new int[matrix[0].length];
        int[]right = new int[matrix[0].length];
        Stack<Integer>st = new Stack<>();
        int maxArea = 0;

        for(char[]arr : matrix){
            for(int i=0; i<arr.length; i++){
                if(arr[i]=='0') heights[i] = 0;
                else heights[i]++;
            }
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < heights.length; i++) {
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    int h = heights[stack.pop()];
                    int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, h * w);
                }
                stack.push(i);
            }
            

            
        }

        return maxArea;
    }

    
}