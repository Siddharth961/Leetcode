class Solution {
    int[][][]dp;
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int r = grid.size();
        int c = grid.get(0).size();

        boolean[][]visited = new boolean[r][c];
        dp = new int[r][c][r+c+1];

        for(int[][]arr : dp) for(int[]a : arr) Arrays.fill(a, -1);
        
        return get_ans(0, 0, grid, health, visited) == 1;
    }

    public int get_ans(int i, int j, List<List<Integer>> grid, int health, boolean[][]visited){

        if(i < 0 || j < 0 || i == grid.size() || j == grid.get(0).size()) return 0;

        if( grid.get(i).get(j) == 1) health--;

        if(visited[i][j] || health <= 0) return 0;

        if( i == grid.size() - 1 && j == grid.get(0).size() - 1) return 1;

        if(dp[i][j][health] != -1) return dp[i][j][health];

        int ans = 0;

        visited[i][j]  = true;

        ans = get_ans(i-1, j, grid, health, visited);
        if(ans != 1) ans = get_ans(i, j+1, grid, health, visited);
        if(ans != 1)ans = get_ans(i+1, j, grid, health, visited);
        if(ans != 1)ans = get_ans(i, j-1, grid, health, visited);

        visited[i][j]  = false;
        dp[i][j][health] = ans;

        return ans;
    
    }
}