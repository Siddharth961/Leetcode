class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int min_sum = 0;
        int max_sum = 0;

        for(int i : nums){
            min_sum -= Math.abs(i);
            max_sum += Math.abs(i);
        }
        int[][]dp = new int[nums.length][max_sum - min_sum + 1];

        for(int[]arr : dp) Arrays.fill(arr, -1);

        // System.out.println(min_sum+"--"+max_sum);

        return get_ans(0, 0, target, dp, nums, Math.abs(min_sum));
    }

    public int get_ans(int idx, int ssf, int tar, int[][]dp, int[]nums, int offset){
        if(idx == nums.length){
            if(ssf == tar) return 1;
            return 0;
        }

        if(dp[idx][ssf+offset] != -1) return dp[idx][ssf+offset];

        int left = get_ans(idx+1, ssf + nums[idx], tar, dp, nums, offset);
        int right = get_ans(idx+1, ssf - nums[idx], tar, dp, nums, offset);

        int sum = left+right;

        // System.out.println(ssf+"--"+offset);
        dp[idx][ssf + offset] = sum;

        return sum;
    }
}