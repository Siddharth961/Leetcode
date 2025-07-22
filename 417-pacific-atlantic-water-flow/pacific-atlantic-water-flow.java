
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int r = heights.length;
        int c = heights[0].length;
        boolean[][][]dp = new boolean[r][c][2];
        boolean[][]visited = new boolean[r][c];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){

                travel(i, j, Integer.MAX_VALUE, heights, dp, visited);
            }
        }

        List<List<Integer>> ans = new LinkedList<>();

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){

                if(dp[i][j] == null) continue;

                // System.out.println(i +" - "+ j + " : "+  dp[i][j][0] + " " + dp[i][j][1]);

                if(  dp[i][j][0] && dp[i][j][1] ){
                    List<Integer> ll = new LinkedList<>();
                    ll.add(i);
                    ll.add(j);

                    ans.add(ll);
                }
            }
        }

        return ans;
    }

    public boolean[] travel( int r, int c, int prev, int[][]grid, boolean[][][]dp, boolean[][]visited){

        boolean[]ans = new boolean[2];

        if( r < 0 || c < 0 ){
            ans[0] = true;
            ans[1] = false;
            // if(r == -1 && c== 2){
            //     System.out.println("aa " +  ans[0] + " " + ans[1]);
            // }
            return ans; // only top left reached
        }
        if( r == grid.length || c == grid[0].length ){
            ans[0] = false;
            ans[1] = true;
            return ans; // only bottom right reached
        }
        // System.out.println(11);


        if(prev < grid[r][c] || visited[r][c] == true) return ans; // invalid access


        if(dp[r][c][0] == true && dp[r][c][1] == true){
            // if(r==1 && c==2){
            //     System.out.println("dahi " + dp[r][c][0] + dp[r][c][1]);
            // }
            return dp[r][c];
        }
        visited[r][c] = true;

        boolean[]response = null;

        for(int i=0; i<4; i++){
            if(i==0)response = travel( r-1, c, grid[r][c], grid, dp, visited);
            if(i==1)response = travel( r, c+1, grid[r][c], grid, dp, visited);
            if(i==2)response = travel( r+1, c, grid[r][c], grid, dp, visited);
            if(i==3)response = travel( r, c-1, grid[r][c], grid, dp, visited);

            // if(r == 1 && c== 0){
            //     System.out.println( response[0] + " " + response[1]);
            // }

            ans[0] = ans[0] || response[0];
            ans[1] = ans[1] || response[1];
        }

        //  if(r == 0 && c== 2){
        //         System.out.println("ans " + ans[0] + " " + ans[1] +" -- " + prev);
        //     }

        dp[r][c] = new boolean[2];
        dp[r][c][0] = ans[0];
        dp[r][c][1] = ans[1];
         

        visited[r][c] = false;

        return ans;
    }
}