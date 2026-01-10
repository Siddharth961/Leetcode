class Solution {
    public long maximumScore(int[] nums) {

        int n = nums.length;
        
        int[]min_arr = new int[n];

        int min = Integer.MAX_VALUE;

        for(int i=n-1; i>=0; i--){
            min_arr[i] = min;
            min = Math.min(min, nums[i]);
        }

        long pre = 0;
        long ans = Long.MIN_VALUE;

        for(int i=0; i<n-1; i++){
            pre += nums[i];

            ans = Math.max(ans, pre - min_arr[i]);
        }

        return ans;
    }
}