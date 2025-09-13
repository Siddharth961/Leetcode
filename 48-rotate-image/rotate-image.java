class Solution {
    public void rotate(int[][] matrix) {
        
        diagwise(matrix);

        for(int r = 0; r<matrix.length; r++){

            int i=0;
            int j = matrix.length - 1;

            while(i < j){
                int temp = matrix[r][i];

                matrix[r][i] = matrix[r][j];
                matrix[r][j] = temp;

                i++;
                j--;
            }
        }

        
    }

    public void diagwise(int [][]matrix){

        for(int diag = 0; diag <matrix.length; diag++){

            for(int i=diag+1; i<matrix.length; i++){

                int temp = matrix[diag][i];
                matrix[diag][i] = matrix[i][diag];
                matrix[i][diag] = temp;
            }
        }
    }
}