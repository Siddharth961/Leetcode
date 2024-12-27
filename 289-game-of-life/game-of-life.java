class Solution {
    public void gameOfLife(int[][] board) {
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                convert(i, j, board);
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == -1) board[i][j] = 0;
                if(board[i][j] == 2) board[i][j] = 1;
            }
        }
    }

    public void convert(int i, int j, int[][]board){

        int ones = 0;

        int r = i-1;
        int c = j-1;

        for( ; c <= j+1; c++ ){

            if(r<0 || c<0 || r>=board.length || c>= board[0].length) continue;
            if( Math.abs(board[r][c]) == 1) ones++;
        }

        r = i;
        c = j-1;


        for( ; c <= j+1; c++ ){

            if(r<0 || c<0 || r>=board.length || c>= board[0].length || c==j) continue;
            if( Math.abs(board[r][c]) == 1) ones++;
        }

        r = i+1;
        c = j-1;

        for( ; c <= j+1; c++ ){

            if(r<0 || c<0 || r>=board.length || c>= board[0].length) continue;
            if( Math.abs(board[r][c]) == 1) ones++;
        }


        if( board[i][j] == 1){
            if(ones < 2 || ones>3) board[i][j] = -1;
        }
        else{
            if(ones == 3) board[i][j] = 2;
        }

        
    }
}