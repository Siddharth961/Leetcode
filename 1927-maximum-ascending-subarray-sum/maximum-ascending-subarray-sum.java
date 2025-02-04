class Solution {
    public int maxAscendingSum(int[] nums) {
        
        int i=1;

        int sum = nums[0];
        int ans = nums[0];

        while(i < nums.length){

            if( nums[i-1] < nums[i]) sum += nums[i];
            else sum = nums[i];

            ans = Math.max(ans, sum);
            i++;
            
        }

        return ans;
    }
}