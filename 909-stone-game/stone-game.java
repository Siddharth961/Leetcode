class Solution {
    public boolean stoneGame(int[] piles) {
        // return true;
        int[][]dp = new int[piles.length][piles.length];
        // for(int[]arr : dp) Arrays.fill(dp, -1);
        return get_ans(0, piles.length-1, piles, dp) > 0 ;
    }

    public int get_ans(int st, int en, int[]piles, int[][]dp){
        if(st>en) return 0;

        if(dp[st][en] != 0) return dp[st][en];

        int ans = Math.max(piles[st] - get_ans(st+1, en, piles, dp) , piles[en] - get_ans(st, en-1, piles, dp));

        dp[st][en] = ans;

        return ans;
    }
}