class Solution {
    public int minDays(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;



        if( numIslands(rows, cols, grid) != 1 ) return 0;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==1){
                    grid[i][j] = 0;
                    if( numIslands(rows, cols, grid) != 1 ) return 1;
                    grid[i][j] = 1;

                }
            }
        }

        return 2;
    }

    public int numIslands(int rows, int cols, int[][] grid) {
        int ans = 0;
        boolean[][]visited = new boolean[rows][cols];

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    ans++;
                    travel(i, j, visited, grid);
                }
            }
        }

        return ans;
    }

    public void travel(int i, int j, boolean[][]visited, int[][]grid){

        if(i<0 || j<0 || i==grid.length || j==grid[0].length || grid[i][j]==0 || visited[i][j]==true) return;

        visited[i][j]= true;
        travel(i-1, j, visited, grid);
        travel(i, j+1, visited, grid);
        travel(i+1, j, visited, grid);
        travel(i, j-1, visited, grid);
    }
}