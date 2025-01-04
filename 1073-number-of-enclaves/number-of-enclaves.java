class Solution {
    public int numEnclaves(int[][] grid) {

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){                

                if(grid[i][j] == 1){
                    boolean val = check(i, j, grid);
                    transform(i , j, val, grid);
                }

            }
        }

        int count = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){

                if(grid[i][j] == 2) count++;

            }
        }

        return count;

    }

    public boolean check (int i, int j, int[][]board){
        if(i < 0 || j<0 || i>=board.length || j >= board[0].length ) return true;
        if(board[i][j] != 1) return false;

        board[i][j] = -1;

        boolean safe = false;


        safe = check( i-1, j, board) || safe;
        safe = check( i, j+1, board) || safe;
        safe = check( i+1, j, board) || safe;
        safe = check( i, j-1, board) || safe;

        return safe;
    }

    public void transform(int i, int j, boolean safe, int[][]board){

        if(i < 0 || j<0 || i>=board.length || j >= board[0].length ) return ;
        if(board[i][j] == 0 || board[i][j] == -2 || board[i][j]==2) return ;

        if(safe) board[i][j] = -2;
        else board[i][j] = 2;
        

        transform( i-1, j, safe, board) ;
        transform( i, j+1, safe, board) ;
        transform( i+1, j, safe, board) ;
        transform( i, j-1, safe, board) ;

    }
}