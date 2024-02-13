class Solution {
    int ans = 0;
    public int uniquePathsIII(int[][] grid) {
        int count = 0;
        int sr = 0;
        int sc = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==0 || grid[i][j]==1) count++;
                if(grid[i][j]==1){
                    sr = i;
                    sc = j;
                }
            }
        }

        int[][]bt = new int[grid.length][grid[0].length];

        get_ans(sr, sc, grid, bt, count);
        return ans;
    }

    public void get_ans(int i, int j, int[][]arr, int[][]bt, int count){

        if(i<0 || i>=arr.length || j<0 || j>=arr[0].length) return;

        if(count==0 && arr[i][j]==2){
            ans++;
            return;
        }

        if(arr[i][j]==-1 || arr[i][j]==2) return;

        if(bt[i][j] == 1) return;

        bt[i][j] = 1;

        get_ans(i-1, j, arr, bt, count-1);
        get_ans(i, j+1, arr, bt, count-1);
        get_ans(i+1, j, arr, bt, count-1);
        get_ans(i, j-1, arr, bt, count-1);

        bt[i][j] = 0;


    }
}