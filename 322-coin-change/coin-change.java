class Solution {
    public int coinChange(int[] coins, int amt) {

        int[]dp = new int[amt + 1];
        dp[0] = 0;

        for(int i=1; i<=amt; i++){

            int min = Integer.MAX_VALUE - 1;

            for(int coin : coins){
                if(i-coin >= 0) min = Math.min(min, dp[i-coin]);
            }

            dp[i] = min + 1;
        }

        if(dp[amt] == Integer.MAX_VALUE) return -1;
        return dp[amt];
        
    }
}