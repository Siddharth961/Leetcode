class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){

                if( grid[i][j] == '1'){
                    ans++;
                    travel(i, j, grid);
                }
            }
        }

        return ans;
    }

    public void travel(int i, int j, char[][]grid){

        if(i<0 || j<0 || i==grid.length || j==grid[0].length){
            return;
        }

        if( grid[i][j] == '0') return;

        grid[i][j] = '0';

        travel(i+1, j, grid);
        travel(i, j+1, grid);
        travel(i-1, j, grid);
        travel(i, j-1, grid);
    }
}