class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;

        int[]max_left = new int[n];

        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, nums[i]);

            max_left[i] = max;
        }

        int[]min_right = new int[n];

        int min = nums[n-1];
        for(int i=n-1; i>=0; i--){
            min = Math.min(min, nums[i]);

            min_right[i] = min;
        }


        int[]ans = new int[n];

        ans[n-1] = max_left[n-1];

        for(int i=n-2; i>=0; i--){

            ans[i] = max_left[i];


            if(max_left[i] > min_right[i+1]) ans[i] = ans[i+1];
        }

        return ans;

        
        
    }

    
}