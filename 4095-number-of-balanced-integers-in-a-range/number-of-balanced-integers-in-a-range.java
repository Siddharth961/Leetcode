class Solution {

    long[][][]dp = new long[17][200][2]; // digit, sumOdd - sumEven, tight

    int offset = 100;
    
    public long countBalanced(long low, long high) {

        for(long[][]a : dp){
            for(long[]b : a){
                Arrays.fill(b, -1);
            }
        }

        long right = get_ans(high + "", 0, 0, 1) ;

        dp = new long[17][200][2];
        for(long[][]a : dp){
            for(long[]b : a){
                Arrays.fill(b, -1);
            }
        }

        long left = get_ans( (low-1) + "", 0, 0, 1);
        
        return right - left; 
    }

    public long get_ans(String num, int idx, int diff, int tight){

        if(idx == num.length()){
            // we have set all the digits

            if(diff == 0){
                // valid combi of digits
                return 1;
            }

            return 0;
        }

        if(dp[idx][diff + offset][tight] != -1 ) return dp[idx][diff + offset][tight];


        int bound = tight == 1 ? (num.charAt(idx) - '0') : 9 ;

        long ans = 0;
        int new_tight = 0;

        for(int val=0; val <= bound; val++){

            // we fix current idx to be val and check how many valid combinations we can have

            // so depending on idx..we add val to sum of either odd or even digits fixed so far 

            if( idx % 2 == 0){
                diff -= val;
            }
            else diff += val;

            new_tight = (tight == 1 && val == bound) ? 1 : 0; // we pass tight as true only if all prev and current idx have reached max allowed value
            ans += get_ans(num, idx+1, diff, new_tight); 

            if( idx % 2 == 0){
                diff += val;
            }
            else diff -= val;

        }

        dp[idx][diff + offset][tight] = ans;

        
        return ans;

    }
}