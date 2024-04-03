class Solution {
    public boolean exist(char[][] board, String word) {
        boolean ans = false;

        boolean[][] backtrack = new boolean[board.length][board[0].length];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                ans = get_ans(i, j, board, 0, word, backtrack);
                if(ans==true) break;
            }
            if(ans==true) break;

        }

        return ans;
    }

    public boolean get_ans(int i, int j, char[][]board, int idx, String word, boolean[][] backtrack){
        if(idx==word.length()) return true;
        if(i<0  || i >= board.length || j<0 || j>=board[0].length) return false;
        if(board[i][j] != word.charAt(idx) || backtrack[i][j]==true) return false;

        boolean ans = false;

        backtrack[i][j] = true;

        ans = get_ans(i-1, j, board, idx+1, word, backtrack);
        if(ans==true) return ans;

        ans = get_ans(i, j+1, board, idx+1, word, backtrack);
        if(ans==true) return ans;

        ans = get_ans(i+1, j, board, idx+1, word, backtrack);
        if(ans==true) return ans;

        ans = get_ans(i, j-1, board, idx+1, word, backtrack);

        backtrack[i][j] = false;

        return ans;

    }
}