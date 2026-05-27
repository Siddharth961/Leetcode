class Solution {
    public int[] maxValue(int[] nums) {

        int n = nums.length;

        int[]max = new int[n];
        int[]ans = new int[n];

        max[0] = nums[0];

        for(int i=1; i<n; i++){
            max[i] = Math.max(max[i-1], nums[i]);
        }

        int min = nums[n-1];

        for(int i=n-1; i>=0; i--){

            // only if min on right is LESS than max of left then we can jump there and take ongoing max value
            // otherwise i can only take values from left side

            if(max[i] > min && i != n-1){
                ans[i] = ans[i+1];
            }
            ans[i] = Math.max( ans[i], max[i] );

            min = Math.min(min, nums[i]);
        }

        return ans;
        
    }
}