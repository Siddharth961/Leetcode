class Solution {
    int[][][]dp;
    int modulo = 1_000_000_007;
    public int[] pathsWithMaxScore(List<String> board) {

        dp = new int[board.size()][board.size()][];
        int[]ans =  get_ans(board.size()-1, board.size()-1, board);

        if(ans[0] == -1) ans[0] = 0;
        return ans;
    }

    public int[] get_ans(int i, int j, List<String> board){

        if(i<0 || j<0 ){
            return new int[]{-1, 0};
        }

        char c = board.get(i).charAt(j);

        if(c == 'X') return new int[]{-1, 0};

        if(i == 0 && j == 0){
            return new int[]{0, 1}; // cost 0 , path 1
        }

        if(dp[i][j] != null) return dp[i][j];

        int[] ans = new int[2];

        int[]up = get_ans(i-1, j, board);
        int[]left = get_ans(i, j-1, board);
        int[]left_up = get_ans(i-1, j-1, board);

        ans[0] = Math.max(left[0], Math.max(up[0], left_up[0]) );

        if(ans[0] == up[0]) ans[1] = (ans[1] + up[1]) % modulo;
        if(ans[0] == left[0]) ans[1] = (ans[1] + left[1]) % modulo;
        if(ans[0] == left_up[0]) ans[1] = (ans[1] + left_up[1]) % modulo;


        if(ans[0] != -1 && c>= '0' && c <='9') ans[0] += (int)(c - '0');

        dp[i][j] = ans;

        return ans;
    }
}