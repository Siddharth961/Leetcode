class Solution {
    
    public int findTargetSumWays(int[] nums, int target) {

        int[][]dp = new int[nums.length][2001];

        for(int[]arr : dp) Arrays.fill(arr, -1);

        return get_ans(0, 0, nums, target, dp);
        
    }

    public int get_ans(int idx, int ssf, int[]nums, int tar, int[][]dp){

        if(idx == nums.length){
            if(ssf == tar) return 1;
            return 0;
        }

        if( dp[idx][ssf + 1000] != -1 ) return dp[idx][ssf + 1000];

        int ans = 0;

        ans += get_ans(idx + 1, ssf + nums[idx], nums, tar, dp);
        ans += get_ans(idx + 1, ssf - nums[idx], nums, tar, dp);

        dp[idx][ssf + 1000] = ans;
        return ans;
    }
}