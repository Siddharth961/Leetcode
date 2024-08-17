class Solution {
    public long maxPoints(int[][] points) {

        int n = points.length;
        int m = points[0].length;
        long val = 0;
        
        long[][]dp = new long[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0){
                    dp[i][j] = points[i][j];
                }

                else{

                    val =  0;
                    for(int k=0; k<m; k++){
                        val = Math.max( val, dp[i-1][k] - Math.abs(j-k));
                    }

                    dp[i][j] = points[i][j] + val;
                }

                // System.out.print(dp[i][j] + " ");
            }

            // System.out.println();
        }

        long max = -1;

        for(int j=0; j<m; j++){
            max = Math.max(max, dp[n-1][j]);
        }

        return max;
    }
}