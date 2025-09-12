class Solution {
    public int jump(int[] nums) {
        
        int[]dp = new int[nums.length];


        for(int i=nums.length-2; i>=0; i--){
            
            int val = Integer.MAX_VALUE-1;
            for(int j=i+1; j<=i+nums[i] && j<nums.length; j++){

                val = Math.min(val, dp[j] + 1);

            }

            dp[i] = val ;

        }

        return dp[0];
    }
}