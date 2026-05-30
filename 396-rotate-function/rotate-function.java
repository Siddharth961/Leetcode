class Solution {
    public int maxRotateFunction(int[] nums) {
        
        int total_sum = 0;
        int rolling_sum = 0;

        int ans = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){

            total_sum += nums[i];
            rolling_sum += i * nums[i];
        }

        ans = Math.max(ans, rolling_sum);

        int st = 0; // start element of previous configuration

        for(int k = 1; k<nums.length; k++){

            // so basically next iteration is nothing but
            // previous rolling sum - ( total_sum - starting number of previous ) + (n-1)*starting number of previous

            // BECAUSE - in next iteration except for staring el, all other elements get multiplication factor reduced by 1 (boldddd) .. so their impact is basically - rolling sum - ( total_sum - starting number of previous ) ALSO starting element had mult fact 0 so we dont need to process its impact in reduction
            // BUTTT the staring element now gets mult fact of (n-1) so we add that

            rolling_sum = rolling_sum - (total_sum - nums[st] ) + ( (nums.length-1) * nums[st]);
            
            ans = Math.max(ans, rolling_sum);

            st++;
        }

        return ans;
    }
}