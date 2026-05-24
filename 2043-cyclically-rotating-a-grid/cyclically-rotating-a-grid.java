class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        
        int rs = 0;
        int cs = 0;

        int re = grid.length - 1;
        int ce = grid[0].length - 1;

        while(rs < re && cs < ce){

            int len = re - rs;
            int wid = ce - cs;

            int peri = 2 * ( len + wid);

            int r = k % peri;

            while(r > 0){

                int temp = grid[rs][cs];

                for(int i=cs; i<ce; i++){
                    grid[rs][i] = grid[rs][i+1];
                }

                for(int i=rs; i<re; i++){

                    grid[i][ce] = grid[i+1][ce];
                }

                for(int i = ce; i>cs; i--){
                    grid[re][i] = grid[re][i-1];
                }

                for(int i=re; i>rs; i--){
                    grid[i][cs] = grid[i-1][cs];
                }

                grid[rs+1][cs] = temp;

                r--;

            }

            rs++;
            cs++;
            re--;
            ce--;


        }

        return grid;
    }
}