class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n= grid[0].length;
        int[][]dp = new int[m][n];
        int val = Integer.MAX_VALUE;

        for(int i=m-1; i>=0; i--){

            for(int j=n-1; j>=0; j--){

                if(i==m-1 && j == n-1){
                    dp[i][j] = grid[i][j];
                    continue;
                }
                
                
                val = Integer.MAX_VALUE;
                if(i+1<m){
                    val = Math.min(val, dp[i+1][j]);
                }
                if(j+1 < n){
                    val = Math.min(val, dp[i][j+1]);
                }

                dp[i][j] = val + grid[i][j];
        
            }
        }

        return dp[0][0];
    }
}