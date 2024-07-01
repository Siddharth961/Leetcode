class Solution {

    public class Point{
        int i;
        int j;

        Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<Point> q = new LinkedList<>();
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                if(grid[i][j]==2) q.add( new Point(i, j)); 
            }
        }

        q.add(new Point(-1, -1)); // level end inidicator

        int ans = 0;

        while(q.size() > 1){

            Point p = q.poll();

            if(p.i==-1){
                q.add(p);
                ans++;
                continue;
            }

            int i = p.i;
            int j = p.j;

            if( i-1>=0 && grid[i-1][j]==1){
                grid[i-1][j] = 2;
                q.add(new Point(i-1, j));
            }
            if( j+1<n && grid[i][j+1]==1){
                grid[i][j+1] = 2;                
                q.add(new Point(i, j+1));
            }
            if( i+1<m && grid[i+1][j]==1){
                grid[i+1][j] = 2;
                q.add(new Point(i+1, j));
            }
            if( j-1>=0 && grid[i][j-1]==1){
                grid[i][j-1] = 2;
                q.add(new Point(i, j-1));
            }

        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                if(grid[i][j]==1) return -1; 
            }
        }

        return ans; 


    }
}