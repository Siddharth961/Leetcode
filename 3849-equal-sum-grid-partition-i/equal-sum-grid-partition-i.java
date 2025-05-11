class Solution {
    public boolean canPartitionGrid(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;

        long[]hori = new long[r];
        long[]verti = new long[c];

        for(int i=0; i<r; i++){

            int sum = 0;
            for(int j=0; j<c; j++){
                sum += grid[i][j];
            }

            if(i==0) hori[i] = sum;
            else hori[i] = sum + hori[i-1];
        }

        for(int i=0; i<r; i++){
            if( hori[i] == hori[r-1] - hori[i]) return true;
        }

        for(int j=0; j<c; j++){

            int sum = 0;
            for(int i=0; i<r; i++){
                sum += grid[i][j];
            }

            if(j==0) verti[j] = sum;
            else verti[j] = sum + verti[j-1];
        }

        for(int i=0; i<c; i++){
            if( verti[i] == verti[c-1] - verti[i]) return true;
        }

        return false;
    }
}