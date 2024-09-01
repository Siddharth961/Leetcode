class Solution {
    public int[][] construct2DArray(int[] orig, int m, int n) {
        int[][]arr = new int[0][] ;
        if(m*n != orig.length) return arr;

        arr = new int[m][n];

        int idx=0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = orig[idx];
                idx++;
            }
        }

        return arr;
    }
}