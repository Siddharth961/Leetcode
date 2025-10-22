class Solution {
    public int numTrees(int n) {
        int[]dp = new int[n+1];
        return get_ans(1, n, dp);
    }

    public int get_ans(int st, int en, int[]dp){

        if(st > en) return 1;

        if(st == en) return 1;

        if(dp[en-st+1] != 0) return dp[en-st+1];
        int ans = 0;


        for(int i=st; i<=en; i++){
            
            int val = get_ans( st, i-1, dp) * get_ans(i+1, en, dp);

            // if(i == 2 && st == 1 && en == 3) System.out.println(val);

            ans += val;

        }

        dp[en-st+1] = ans;

        return ans;
    }

}