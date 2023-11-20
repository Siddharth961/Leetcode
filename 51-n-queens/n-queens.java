class Solution {
    List<List<String>> al = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        boolean[][]board = new boolean[n][n];
        ways(0,0, n,board);
        return al;

        
    }

    public void ways(int r, int qsf,int n, boolean[][]board){

        if(r>=n){
            if(qsf==n) ans(board);
            return;
        }

        for( int c=0; c<n; c++){

            if(check(board,r,c)==false) continue; //we cant place queen

            board[r][c]=true;

            ways(r+1, qsf+1, n, board);          

            board[r][c]=false; 

        }



    } 

    public boolean check(boolean[][]board, int r, int c){

        //top check
        for(int i=r; i>=0; i--){
            if(board[i][c]==true) return false;
        }

        //left diagonal
        int i=r;
        int j=c;
        while(i>=0 && j>=0){
            if(board[i][j]==true) return false;
            i--;
            j--;
        }

        //right diagonal
        i=r;
        j=c;
        while(i>=0 && j<board.length){
            if(board[i][j]==true) return false;
            i--;
            j++;
        }

        return true;

        
    }

    public void ans(boolean[][]board){
        List<String> temp = new ArrayList<>();
        

        for(int i=0; i<board.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<board.length; j++){
                if(board[i][j]==false) sb.append(".");
                else  sb.append("Q");
            }

            temp.add(sb.toString());
        }

        al.add(temp);
    }
}