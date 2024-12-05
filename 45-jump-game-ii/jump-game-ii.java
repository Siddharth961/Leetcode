class Solution {
    public int jump(int[] nums) {
 
        
        int[]dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[nums.length-1] = 0;



        for(int i=nums.length-2; i>=0 ; i--){

            for(int j = 1; j <= nums[i]; j++){
                if( i+j < nums.length ){
                    dp[i] = Math.min(dp[i], dp[i+j]);
                }
            }

            if(dp[i] != Integer.MAX_VALUE) dp[i]++;

        }

        return dp[0];
    
    }
}