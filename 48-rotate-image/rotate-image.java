class Solution {
    public void rotate(int[][] matrix) {

        int temp = 0;
        
        for(int i=0; i<matrix.length; i++){

            for(int j=0; j<i; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int j=0; j<matrix[0].length/2; j++){
            for(int i=0; i<matrix.length; i++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][ matrix[0].length-1-j ];
                matrix[i][ matrix[0].length-1-j ] = temp;
            }
        }

        for(int[]arr : matrix){
            for(int i:arr) System.out.print(i+" ");
            System.out.println();
        }
    }
}