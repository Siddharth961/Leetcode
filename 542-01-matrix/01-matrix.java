class Solution {

    public class Point{
        int x ;
        int y ;
        
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;

        int[][]ans = new int[n][m];
        for(int[]arr : ans) Arrays.fill(arr, -1);

        Queue<Point> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                if(mat[i][j] == 0){
                    q.add( new Point(i, j));
                    ans[i][j] = 0;
                }
            }
        }

        // q.add( new Point(-1, -1));

        while(q.size()>0){

            Point p = q.poll();
            
            int i = p.x;
            int j = p.y;

            

            if(i-1 >= 0 && ans[i-1][j] == -1){

                ans[i-1][j] = ans[i][j] + 1;
                q.add( new Point(i-1 , j));
            }

            if(j+1 < ans[0].length && ans[i][j+1] == -1){

                ans[i][j+1] = ans[i][j] + 1;
                q.add( new Point(i , j+1));
            }

            if(i+1 < ans.length && ans[i+1][j] == -1){

                ans[i+1][j] = ans[i][j] + 1;
                q.add( new Point(i+1 , j));
            }

            if(j-1 >= 0 && ans[i][j-1] == -1){

                ans[i][j-1] = ans[i][j] + 1;
                q.add( new Point(i , j-1));
            }
            
        }

        return ans;
    }
}