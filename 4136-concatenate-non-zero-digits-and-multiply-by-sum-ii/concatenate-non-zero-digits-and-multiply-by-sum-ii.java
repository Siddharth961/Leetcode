class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        
        long mod = 1000000007;
        int n = s.length();

        int[]idx = new int[n+1];
        long[]val = new long[n+1];
        long[]sum = new long[n+1];
        long[]pow10 = new long[n+1];

        pow10[0] = 1;
        for(int i=1; i<=n; i++) pow10[i] = (pow10[i-1]*10)%mod;

        int c=0;

        for(int i=0; i<n; i++){
            int d = s.charAt(i) - '0' ;

            if( d != 0){
                c++;
                val[c] = (val[c-1]*10 + d) % mod;
                sum[c] = (sum[c-1] + d) % mod;
                
            }

            idx[i+1] = c;
        }
        
        int m = queries.length;
        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int a = idx[l];
            int b = idx[r+1];

            if(a == b){
                ans[i] = 0;
                continue;
            }

            int len = b-a;

            long num =( val[b] - ( val[a] * pow10[len] ) % mod + mod) % mod;
            long mult = sum[b] - sum[a];

            ans[i] = (int)( (num * mult) % mod);

        }

        return ans;

    }
}