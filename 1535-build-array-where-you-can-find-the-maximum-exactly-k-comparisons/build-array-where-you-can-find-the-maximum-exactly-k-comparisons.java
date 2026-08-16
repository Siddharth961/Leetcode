class Solution {
    int modulo = 1_000_000_007;
    int[][][]dp;
    public int numOfArrays(int n, int m, int k) {

        dp = new int[m+1][n+1][n];

        for(var a : dp) for(var b : a) Arrays.fill(b, -1);

        return get_ans(0, 0, 0, n, m, k);
        
    }

    public int get_ans(int prev, int len, int idx, int n, int m, int k){
        if(idx == n){
            if(len == k) return 1;
            return 0;
        }

        if(dp[prev][len][idx] != -1) return dp[prev][len][idx];

        int ans = 0;

        for(int val = 1; val <= m; val++){

            if(val > prev){
                ans = (ans + get_ans(val, len+1, idx+1, n, m, k) ) % modulo;
            }

            else {
                ans = (ans + get_ans(prev, len, idx+1, n, m, k) ) % modulo;

            }
        }

        dp[prev][len][idx] = ans;

        return ans;
    }
}