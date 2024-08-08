class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int step = 0;

        int total = rows*cols;
        int[][]ans = new int[total][2];
        int idx = 0;

        int dir = 0;

        ans[0][0] = rStart;
        ans[0][1] = cStart;
        idx++;

        while(idx < total){
            
            if(dir==0 || dir==2) step++;

            for(int count=0; count<step; count++){

                rStart += directions[dir][0];
                cStart += directions[dir][1];

                if(rStart>=0 && cStart>=0 && rStart<rows && cStart<cols){
                    ans[idx][0] = rStart;
                    ans[idx][1] = cStart;
                    idx++;
                }
            }

            dir = (dir+1)%4;
        }

        return ans;
    }
}