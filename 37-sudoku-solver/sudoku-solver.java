class Solution {
    public void solveSudoku(char[][] board) {
        List<int[]> list = getList(board);
        // System.out.println(11);
        travel(0, list, board);
    }

    public List<int[]> getList(char[][]board){
        List<int[]> list = new LinkedList<>();

        for(int i=0; i<9; i++){

            for(int j=0; j<9; j++){

                if(board[i][j] == '.'){
                    list.add( new int[]{i,j} );
                }
            }
        }

        return list;
    }

    public boolean travel(int idx, List<int[]> list, char[][]board){

        if(idx == list.size()){

            return true;
        }

        int[]arr = list.get(idx);
        
        for(char c='1'; c<='9'; c++){



            if( isValid(board, arr[0], arr[1], c) ){
                board[ arr[0] ][ arr[1] ] = c;

                if( travel(idx+1, list, board) ) return true;
                board[ arr[0] ][ arr[1] ] = '.';
            }


        }

        return false;
    }

    public boolean isValid(char[][] board, int row, int col, char c) {
    for (int i = 0; i < 9; i++) {

        if (board[row][i] == c) return false;
        if (board[i][col] == c) return false;
        if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
    }
    return true;
    }

}