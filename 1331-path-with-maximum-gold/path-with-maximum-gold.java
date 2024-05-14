class Solution {
    public int getMaximumGold(int[][] grid) {
        boolean[][]back = new boolean[grid.length][grid[0].length];

        int ans = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){

                if(grid[i][j]>0) ans = Math.max(ans, get_ans(i, j, grid, back));
            }
        }

        return ans;
    }

    public int get_ans( int r, int c,  int[][]grid, boolean[][]back){

        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length) return 0;

        if(grid[r][c]==0 || back[r][c]==true) return 0;

        back[r][c] = true;
        int ans = 0;

        ans = Math.max( ans, get_ans(r-1, c, grid, back));
        ans = Math.max( ans, get_ans(r, c+1, grid, back));
        ans = Math.max( ans, get_ans(r+1, c, grid, back));
        ans = Math.max( ans, get_ans(r, c-1, grid, back));

        back[r][c] = false;
        return ans + grid[r][c];

    }
}