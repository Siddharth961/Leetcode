class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){

                if(grid[i][j] == 2) q.add(new int[]{i, j});
                if(grid[i][j] == 1) fresh++;

            }
        }

        int minutes = 0;

        while(q.size() > 0 && fresh > 0){

            int level_size = q.size();

            while(level_size > 0){

                fresh -= spread(q.remove(), q, grid);

                level_size--;
            }

            minutes++;
        }

        if(fresh > 0) return -1;

        return minutes;

    }

    public int spread(int[]coord, Queue<int[]> q, int[][]grid){

        int[][]dirs = new int[][]{
            {0, -1},
            {1, 0},
            {0, 1},
            {-1, 0}
        };

        int count = 0;

        for(int[]a : dirs){

            int x = coord[0] + a[0];
            int y = coord[1] + a[1];

            if(x < 0 || y < 0 || x == grid.length || y == grid[0].length) continue;

            if( grid[x][y] == 1){
                grid[x][y] = 2;
                q.add(new int[]{x, y});
                count++;
            }
        }

        return count;
    }
}