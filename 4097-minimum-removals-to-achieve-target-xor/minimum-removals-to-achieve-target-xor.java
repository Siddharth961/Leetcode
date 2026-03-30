class Solution {
    int[][]dp;
    public int minRemovals(int[] nums, int target) {

        dp = new int[nums.length][17000];

        for(int[]a : dp) Arrays.fill(a, -1);

        int ans = travel(0, 0, nums, target);

        return ans == Integer.MIN_VALUE ? -1 : nums.length - ans;
    }

    public int travel(int idx, int xsf, int[]nums, int tar){

        

        if(idx == nums.length){
            if(xsf == tar) return 0;
            return Integer.MIN_VALUE;
        }

        if(dp[idx][xsf] != -1) return dp[idx][xsf];

        int ans = Integer.MIN_VALUE;

        // take it
        int val = travel(idx+1, xsf^nums[idx], nums, tar) ;
        if(val != Integer.MIN_VALUE) val = val+1;

        //leave it

        int val2 = travel(idx+1, xsf, nums, tar);
        
        ans = Math.max(val, val2);

        dp[idx][xsf] = ans;

        return ans;

        

        
    }
}