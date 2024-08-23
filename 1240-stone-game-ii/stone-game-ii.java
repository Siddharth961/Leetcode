class Solution {
    public int stoneGameII(int[] piles) {
        int[][][]dp = new int[2][101][101];

        return playAlice(0, 0, 1, piles, dp);
    }

    public int playAlice(int player, int idx, int m, int[]piles, int[][][]dp){

        // System.out.println(player+" "+idx+" "+m);
        if(idx >= piles.length) return 0;

        if(dp[player][idx][m] != 0) return dp[player][idx][m];

        int stones = 0;
        int ans = player == 0 ? -1 : Integer.MAX_VALUE;

        for(int i=idx; i<piles.length && i<idx+ 2*m; i++){

            if(player == 0){
                stones += piles[i];
                ans = Math.max(ans, stones + playAlice(1, i+1, Math.max(i-idx+1 ,m), piles, dp) );
            }
            else{
                ans = Math.min(ans, playAlice(0, i+1, Math.max(i-idx+1 ,m), piles, dp) );
            }

        }

        dp[player][idx][m] = ans;
        return ans;
    }
}