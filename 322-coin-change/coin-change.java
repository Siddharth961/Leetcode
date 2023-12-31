class Solution {
    public int coinChange(int[] coins, int amt) {
        int[]dp = new int[amt + 1];
        
        for(int i=1; i<dp.length; i++){
            int min = Integer.MAX_VALUE-1;

            for(int j=0; j<coins.length; j++){

                if(i-coins[j]>=0) min = Math.min(dp[i-coins[j]] , min);
            }

            dp[i] = min + 1;
            
        }

        if(dp[amt]!= Integer.MAX_VALUE)return dp[amt];
        return -1;
    }
}