class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][]dp = new int[k][n];
        for(int[]arr : dp) Arrays.fill(arr, 1);

        int max = 0;

        for(int i=0; i<n; i++){

            for(int j=0; j<i; j++){

                int mod = (nums[j] + nums[i]) % k;

                dp[mod][i] = Math.max( dp[mod][i], 1 + dp[mod][j]);

                max = Math.max(max, dp[mod][i]);
            }
        }

        return max;
    }
}