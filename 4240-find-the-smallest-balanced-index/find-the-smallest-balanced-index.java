class Solution {
    public int smallestBalancedIndex(int[] nums) {
        
        long total_sum = 0;
        for(int i: nums) total_sum += i;

        long ongoing_pro = 1;
        long ongoing_sum = 0;

        int ans = -1;

        for(int i=nums.length-1; i>=0; i--){


            ongoing_sum += nums[i];

            long curr_sum = total_sum - ongoing_sum;

            if(curr_sum == ongoing_pro) ans = i;

            if( ongoing_pro > Long.MAX_VALUE/ nums[i]) break;

            ongoing_pro *= nums[i];
        }

        return ans;

        
    }
}