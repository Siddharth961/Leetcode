class Solution {

    int modulo = 1_000_000_007;
    int[][][]dp; // [prev][el-count][ inc or dec]

    public int zigZagArrays(int n, int l, int r) {

        int m = r-l+1;

        dp = new int[m+1][n+1][2];

        for(int val = 1; val <= m; val++){
            dp[val][n][0] = 1;
            dp[val][n][1] = 1;
        }

        // agr me iss ith pos pr "prev" val ke saath aya hu to kitne seq bnege

        // ya fir
        // me iss i pe curr val rkhu to inc or dec kitne kitne seq bnege

        // pr one thing - say inc ke liye next should be - curr +1 or curr + 2...
        // me hr next ki value check kru?
        // agr i+1 pos ke (next+1) pe saare next+1, +2, +3 sb ka sum rkha ho to?

        for(int i=n-1; i>=0; i--){

            int[]preSum0 = new int[m+1];
            int[]preSum1 = new int[m+1];

            for(int val=1; val <= m; val++){
                preSum0[val] = (preSum0[val-1] + dp[val][i+1][0]) % modulo;

                preSum1[val] = (preSum1[val-1] + dp[val][i+1][1]) % modulo;
            }

            for(int curr = 1; curr <= m; curr++){

                // make  seq,

                int inc = (preSum1[m] - preSum1[curr] + modulo) % modulo;
                int dec = preSum0[curr-1];

                dp[curr][i][0] = inc;
                dp[curr][i][1] = dec;
            }
        }

        int ans = 0;

        for(int val = 1; val<=m; val++){

            ans = (ans  + dp[val][1][0] ) % modulo;
            ans = (ans  + dp[val][1][1] ) % modulo;
        }

        return ans;

        // dp = new int[r+1][n+1][2];

        // for(int[][]arr : dp) for(int[]a : arr) Arrays.fill(a, -1);

        // int ans = 0;
        
        // for(int i=l; i<=r; i++){
        //     int val = get_ans(i, 0, l, r, 1, n);
        //     ans = (ans + val) % modulo;
        //     val = get_ans(i, 1, l, r, 1, n);
        //     ans = (ans + val) % modulo;
        // }

        // return ans;
    }

    // public int get_ans(int prev, int prev_seq, int l, int r, int el_count, int n){

    //     if(el_count == n){
    //         return 1;
    //     }

    //     if(dp[prev][el_count][prev_seq] != -1 ){
    //         return dp[prev][el_count][prev_seq];
    //     }

    //     int ans = 0;

    //     if(prev_seq == 0){ // previous was inc need to decrease now
            
    //         for(int curr = prev-1; curr >= l; curr--){

    //             int val = get_ans(curr, 1, l, r, el_count + 1, n);

    //             ans = (ans + val) % modulo;

    //         }

    //     }

    //     else{ // prev was dec now inc

    //         for(int curr = prev+1; curr <= r; curr++){

    //             int val = get_ans(curr, 0, l, r, el_count + 1, n);

    //             ans = (ans + val) % modulo;

    //         }
    //     }

    //     dp[prev][el_count][prev_seq] = ans;

    //     return ans;

    // }
}