class Solution {
    public boolean exist(char[][] board, String word) {

        boolean[][]visited = new boolean[board.length][ board[0].length];
        
        for(int i=0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){

                if( check(i, j, 0, word, board, visited) ) return true;
            }
        }

        return false;
    }

    public boolean check(int i, int j, int idx, String word, char[][]board, boolean[][]visited){

        if(idx == word.length() ) return true;

        if(i<0 || j<0 || i==board.length || j==board[0].length){
            return false;
        }

        if(board[i][j] != word.charAt(idx) || visited[i][j]) return false;

        visited[i][j] = true;

        boolean ans = false;

        ans = ans || check(i-1, j, idx+1, word, board, visited);
        ans = ans || check(i, j+1, idx+1, word, board, visited);
        ans = ans || check(i+1, j, idx+1, word, board, visited);
        ans = ans || check(i, j-1, idx+1, word, board, visited);

        // if(ans == true){
        //     System.out.println(i + " " + j+ " " + idx);
        // }

        visited[i][j] = false;

        return ans;
    }
}