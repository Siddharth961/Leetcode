class Solution {
    int[][]dp;
    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a,b) -> a[0] - b[0]);
        dp = new int[pairs.length][pairs.length];
        for(int[]a : dp) Arrays.fill(a , -1);

        return get_ans(-1, 0, pairs);
    }

    public int get_ans(int prev, int curr, int[][]pairs){

        if(curr == pairs.length ) return 0;

        if(prev != -1 && dp[prev][curr] != -1) return dp[prev][curr];

        // take

        int ans = 0;

        if(prev == -1 ||  pairs[ prev ][1] < pairs[ curr ][0] ){

            ans = 1 + get_ans(curr, curr+1, pairs);

        }

        // no take

        ans = Math.max(ans, get_ans(prev, curr+1, pairs) );

        if(prev != -1 ) dp[prev][curr] = ans;

        return ans;

    }
}