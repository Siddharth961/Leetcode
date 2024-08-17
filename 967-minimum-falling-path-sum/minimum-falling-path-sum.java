class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;

        int[][]dp = new int[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                if(i==0) dp[i][j] = matrix[i][j];
                else{

                    int val = Integer.MAX_VALUE;

                    for(int k=-1; k<=1; k++){
                        if(j+k>=0 && j+k<n) val = Math.min(val, dp[i-1][j+k]);
                    }

                    dp[i][j] = val + matrix[i][j];
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int j=0; j<n; j++) ans = Math.min(ans, dp[n-1][j]);

        return ans;
    }
}