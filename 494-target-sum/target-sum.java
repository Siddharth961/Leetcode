class Solution {
    int ans = 0;
    public int findTargetSumWays(int[] nums, int target) {
        get_ans(0, 0, nums, target);
        return ans;
    }

    public void get_ans(int idx, int ssf, int[]nums, int tar){

        if(idx == nums.length){
            if(ssf == tar) ans++;
            return ;
        }

        get_ans(idx + 1, ssf + nums[idx], nums, tar);
        get_ans(idx + 1, ssf - nums[idx], nums, tar);
    }
}