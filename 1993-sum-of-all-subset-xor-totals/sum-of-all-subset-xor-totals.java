class Solution {
    int ans = 0;
    public int subsetXORSum(int[] nums) {
        get_ans(0, -1, nums);
        return ans;
    }

    public void get_ans(int idx, int asf, int[]nums){
        if(idx==nums.length){
            if(asf!=-1)ans += asf;
            return;
        }

        get_ans(idx+1, asf, nums);
        
        int val = asf == -1 ? nums[idx] : asf^nums[idx];

        get_ans(idx+1, val, nums);
    }
}