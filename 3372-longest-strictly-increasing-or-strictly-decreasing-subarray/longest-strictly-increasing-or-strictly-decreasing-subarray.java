class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans = 1;
        int inc_len = 1;
        int dec_len = 1;

        for(int i=1; i<nums.length; i++){

            if(nums[i-1] > nums[i]){
                dec_len++;
                inc_len = 1;
            }
            else if(nums[i-1] < nums[i]){
                inc_len++;
                dec_len = 1;
            }
            else{
                inc_len = 1;
                dec_len = 1;
            }

            ans = Math.max( ans, Math.max(inc_len, dec_len));

        }

        return ans;
    }
}