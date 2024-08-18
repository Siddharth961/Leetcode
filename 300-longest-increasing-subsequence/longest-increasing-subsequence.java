class Solution {
    public int lengthOfLIS(int[] nums) {

        int ans = 0;
        int[]dp = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            ans = Math.max(ans, get_ans(i, nums, dp));
        }

        return ans;
        
    }

    public int get_ans(int idx, int[]nums, int[]dp){
        
        if( dp[idx] != 0) return dp[idx];

        int len = 0;
        for(int i=idx+1; i<nums.length; i++){
            if(nums[idx] < nums[i]){
                len = Math.max(len, get_ans(i, nums, dp));
            }
        }

        len++;
        dp[idx] = len;
        return len;
    }
}