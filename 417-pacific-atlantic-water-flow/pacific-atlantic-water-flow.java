class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] grid) {
        
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<grid.length; i++){
            q.add(new int[]{i, 0});
        }
        for(int i=0; i<grid[0].length; i++){
            q.add(new int[]{0, i});
        }

        boolean[][]pacific = bfs(q, grid);

        for(int i=0; i<grid.length; i++){
            q.add(new int[]{i, grid[0].length - 1});
        }
        for(int i=0; i<grid[0].length; i++){
            q.add(new int[]{grid.length - 1, i});
        }

        boolean[][]atlantic = bfs(q, grid);

        List<List<Integer>> ans = new LinkedList<>();

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){

                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer>ll  = new LinkedList<>();
                    ll.add(i);
                    ll.add(j);
                    ans.add(ll);
                }
            }
        }

        return ans;


    }

    public  boolean[][] bfs(Queue<int[]> q , int[][]grid){

        boolean[][]visited = new boolean[grid.length][grid[0].length];

        while(q.size() > 0){

            int[]point = q.remove();
            int r = point[0];
            int c = point[1];

            if(  visited[r][c] ) continue;

            visited[r][c] = true;
            // ans[r][c]++;

            if(r+1 < grid.length && grid[r+1][c] >= grid[r][c]) q.add(new int[]{r+1, c});
            if(c+1 < grid[0].length && grid[r][c+1] >= grid[r][c]) q.add(new int[]{r, c+1});
            if(r-1 >= 0 && grid[r-1][c] >= grid[r][c]) q.add(new int[]{r-1, c});
            if(c-1 >= 0 && grid[r][c-1] >= grid[r][c]) q.add(new int[]{r, c-1});
        }

        return visited;

    }
}