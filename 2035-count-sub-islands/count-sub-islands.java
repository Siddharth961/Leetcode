class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        boolean[][]visited = new boolean[grid2.length][grid2[0].length];
        int ans = 0;
        for(int i=0; i<grid2.length; i++){
            for(int j=0; j<grid2[0].length; j++){

                if(visited[i][j] == false && grid2[i][j] == 1){
                    if( get_ans(i, j, visited, grid1, grid2) != -1) ans++;
                }
            }
        }

        return ans;
    }

    public int get_ans(int r, int c, boolean[][]visited, int[][] grid1, int[][] grid2){

        if(r<0 || c<0 || r>=grid2.length || c>=grid2[0].length) return 0;
        if(visited[r][c] == true || grid2[r][c] == 0) return 0;

        visited[r][c] = true;

        int ans = 0;
        if(grid1[r][c] != 1) ans =  -1;


        ans = Math.min(ans, get_ans(r-1, c, visited, grid1, grid2) );
        
        ans = Math.min(ans, get_ans(r, c+1, visited, grid1, grid2) );

        ans = Math.min(ans, get_ans(r+1, c, visited, grid1, grid2) );

        ans = Math.min(ans, get_ans(r, c-1, visited, grid1, grid2) );

        // if(r==2 && c==1) System.out.println(ans);

        return ans;

    }
}