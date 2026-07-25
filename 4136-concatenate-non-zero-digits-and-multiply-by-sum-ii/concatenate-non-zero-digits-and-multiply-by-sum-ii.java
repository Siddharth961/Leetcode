class Solution {
    public int[] sumAndMultiply(String str, int[][] queries) {

        int n = str.length();
        int modulo = 1_000_000_007;
        
        int[]conc_val = new int[n];
        int[]sum = new int[n];
        int[]digits = new int[n];

        int conc = 0;
        int s = 0;
        int d = 0;

        for(int i=0; i<str.length(); i++){

            int val = str.charAt(i) - '0';

            if(val != 0){
                
                conc = (int)((conc * 10L + val) % modulo);
                s = (s + val) % modulo;
                d++;
            }

            conc_val[i] = conc;
            sum[i] = s;
            digits[i] = d;
        }


        long[] pow10 = new long[d + 1];
        pow10[0] = 1;

        for (int i = 1; i <= d; i++) {
            pow10[i] = (pow10[i - 1] * 10) % modulo;
        }

        int[]ans = new int[queries.length];

        int idx = 0;
        for(int[]q : queries){

            int l = q[0] - 1;
            int r = q[1];
            
            if(l < 0){
                ans[idx] = (int)( (conc_val[r] * 1L * sum[r]) % modulo );
            }
            else{

                long pow = pow10[digits[r] - digits[l]];

                long conc_q = (conc_val[r] - (conc_val[l] * pow) % modulo + modulo) % modulo;

                long sum_q = (sum[r] - sum[l] + modulo) % modulo;

                ans[idx] = (int)((conc_q * sum_q) % modulo);
            }

            idx++;
        }

        return ans;
    }
}