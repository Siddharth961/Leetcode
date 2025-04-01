class Solution {
    public long mostPoints(int[][] ques) {
        
        long[]dp = new long[ques.length];

        long taken = 0;
        long not_taken = 0;

        for(int i=ques.length - 1; i>=0; i--){

            taken = ques[i][0];

            if( (i + ques[i][1] + 1) < ques.length) taken += dp[ i + ques[i][1] + 1 ];

            if(i+1 < ques.length) not_taken = dp[i+1];

            dp[i] = Math.max(taken, not_taken);

        }

        return dp[0];
    }
}