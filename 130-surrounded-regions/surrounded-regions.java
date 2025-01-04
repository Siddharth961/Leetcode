class Solution {
    public void solve(char[][] board) {
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){                

                if(board[i][j] == 'O'){
                    boolean val = check(i, j, board);
                    transform(i , j, val, board);
                }

            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){

                if(board[i][j] == 'W') board[i][j] = 'O';

            }
        }


    }

    public void transform(int i, int j, boolean safe, char[][]board){

        if(i < 0 || j<0 || i>=board.length || j >= board[0].length ) return ;
        if(board[i][j] == 'X' || board[i][j] == 'W') return ;

        if(safe) board[i][j] = 'W';
        else board[i][j] = 'X';
        

        transform( i-1, j, safe, board) ;
        transform( i, j+1, safe, board) ;
        transform( i+1, j, safe, board) ;
        transform( i, j-1, safe, board) ;

    }

    public boolean check (int i, int j, char[][]board){
        if(i < 0 || j<0 || i>=board.length || j >= board[0].length ) return true;
        if(board[i][j] != 'O') return false;

        board[i][j] = 'V';

        boolean safe = false;


        safe = check( i-1, j, board) || safe;
        safe = check( i, j+1, board) || safe;
        safe = check( i+1, j, board) || safe;
        safe = check( i, j-1, board) || safe;

        return safe;
    }
}