class Solution {
    public int matrixScore(int[][] grid) {
        
        for(int i=0; i<grid.length; i++){
            if(grid[i][0] == 0) fliprow( i, grid);
        }

        int zeroes = 0;

        for(int j=0; j<grid[0].length; j++){

            zeroes = 0;

            for(int i=0; i<grid.length; i++){
                if(grid[i][j]==0) zeroes++;
            }

            if(zeroes > grid.length/2) flipcol(j, grid);
        }

        

        return calc(grid);
    }

    public void fliprow( int r, int[][]grid){

        for(int i=0; i<grid[0].length; i++){
            if(grid[r][i] == 0) grid[r][i] = 1;
            else grid[r][i] = 0;
        }
    }

    public void flipcol( int c, int[][]grid){

        for(int i=0; i<grid.length; i++){
            if(grid[i][c] == 0) grid[i][c] = 1;
            else grid[i][c] = 0;
        }
    }

    public int calc(int[][]grid){

        int pow = 0;
        int ans = 0;

        for(int i=0; i<grid.length; i++){
            pow = 0;
            for(int j=grid[0].length-1; j>=0; j--){

                ans += grid[i][j] * Math.pow(2, pow);
                pow++;
            }
        }

        return ans;
    }
} 