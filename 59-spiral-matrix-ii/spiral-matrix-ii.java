class Solution {
    public int[][] generateMatrix(int n) {

        int[][]matrix = new int[n][n];

        int rs = 0;
        int cs = 0;
        int re = n-1;
        int ce = n-1;

        int total = n*n;
        int count = 1;

        while(count <= total &&  rs<=re && cs <= ce){

            if(count <= total){
                for(int i=cs; i<=ce; i++){
                    matrix[rs][i] = count;
                    count++;
                }

            }
            rs++;

            if(count <= total){
                for(int i=rs; i<=re; i++){
                    matrix[i][ce] = count;
                    count++;
                }

            }
            ce--;

            if(count <= total){
                for(int i=ce; i>=cs; i--){
                    matrix[re][i] = count;
                    count++;
                }

            }
            re--;

            if(count <= total){
                for(int i=re; i>=rs; i--){
                    matrix[i][cs] = count;
                    count++;
                }

            }
            cs++;
        }

        return matrix;

    }
}