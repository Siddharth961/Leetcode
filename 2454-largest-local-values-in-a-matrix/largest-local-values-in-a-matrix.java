class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;

        int[][]ans = new int[n-2][n-2];

        for(int r = 0; r<n-2; r++){
            for(int c = 0; c<n-2; c++){
                ans[r][c] = calc(r, c, grid);
            }
        }

        return ans;
    }

    public int calc(int r, int c, int[][]grid){

        int max = -1;

        for(int i=r; i<=r+2; i++){
            for(int j=c; j<=c+2; j++){
                if(max<grid[i][j]) max = grid[i][j];
            }
        }

        return max;
    }
}