class Solution {
    public int minPathSum(int[][] grid) {
        
        int[][]dp = new int[grid.length][grid[0].length];

        for(int[]arr : dp) Arrays.fill(arr, -1);

        return get_ans(0, 0, grid, dp);
    }

    public int get_ans(int r, int c, int[][]grid, int[][]dp){
        if(r == grid.length || c == grid[0].length) return Integer.MAX_VALUE;

        if(dp[r][c] != -1) return dp[r][c];

        int ans = get_ans(r+1, c, grid, dp);

        ans = Math.min(ans, get_ans(r, c+1, grid, dp));

        if(ans == Integer.MAX_VALUE) ans = 0;
        ans += grid[r][c];

        dp[r][c] = ans;
        return ans;
    }
}