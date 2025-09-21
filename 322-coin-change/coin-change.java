class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[]dp = new int[amount+1];

        for(int i=amount-1; i>=0; i--){

            int val = Integer.MAX_VALUE;

            for(int j=0; j<coins.length; j++){

                if( coins[j] <= amount && i + coins[j] <= amount){
                    val = Math.min(val, dp[i + coins[j]]);
                }
            }

            dp[i] = val == Integer.MAX_VALUE ? val : val + 1;
        }

        return dp[0] == Integer.MAX_VALUE ? -1 : dp[0];
    }
}