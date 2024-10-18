class Solution {
    public int maxRemovals(String source, String pattern, int[] tar_idx) {
        

        char[]src = source.toCharArray();
        char[]pat = pattern.toCharArray();

        int[][]dp = new int[src.length+1][pat.length+1];
        for(int[]arr : dp) Arrays.fill(arr, -1); 

        return get_ans(src, pat, tar_idx, 0, 0, 0, dp);

    }

    public int get_ans( char[]src, char[]pat, int[]tar, int s, int p, int t, int[][]dp){

        if( p == pat.length){
            return tar.length - t;
        }

        if( s >= src.length ){
            return Integer.MIN_VALUE;
        }

        if(dp[s][p] != -1)return dp[s][p];
     

        while(s < src.length && p < pat.length){

            if( t < tar.length && s == tar[t]){
                break;
            }

            if( src[s] == pat[p]){
                p++;
            }

            s++;
        }

        if( t == tar.length ){
            if( p == pat.length) return 0;
            else return Integer.MIN_VALUE;
        }

        int rem = 1 + get_ans(src, pat, tar, s+1, p, t+1, dp);
        int not_rem = get_ans(src, pat, tar, s, p, t+1, dp);

        dp[s][p] = Math.max(rem, not_rem);

        return dp[s][p];

        
    }
}