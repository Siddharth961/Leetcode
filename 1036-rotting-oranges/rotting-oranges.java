class Solution {

    public class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {

        Queue<Point> q = new LinkedList<>();

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2) q.add( new Point(i, j));
            }
        }

        q.add( new Point(-1, -1));
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;

        while(q.size() > 1){

            Point p = q.poll();

            if(p.x == -1){
                q.add(p);
                ans++;
                continue;
            }

            int i = p.x;
            int j = p.y;

            if(i-1 >=0 && grid[i-1][j] == 1){
                grid[i-1][j] = 2;
                q.add( new Point(i-1, j));
            }

            if(j+1 < m && grid[i][j+1] == 1){
                grid[i][j+1] = 2;
                q.add( new Point(i, j+1));
            }
            if(i+1 <n && grid[i+1][j] == 1){
                grid[i+1][j] = 2; 
                q.add( new Point(i+1, j));
            }
            if(j-1 >=0 && grid[i][j-1] == 1){
                grid[i][j-1] = 2;
                q.add( new Point(i, j-1));
            }



        }

        for(int[]arr : grid){
            for(int i : arr) if( i == 1) return -1;
        }

        return ans;


        
    }
}