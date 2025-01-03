class Solution {
    public int findCircleNum(int[][] matrix) {
        
        boolean[]visited = new boolean[matrix.length];

        int provinces = 0;

        for(int i=0; i<matrix.length; i++){
            if( !visited[i]){
                provinces++;
                travel(i, visited, matrix);
            }
        }

        return provinces;
    }

    public void travel(int src, boolean[]visited, int[][]matrix){

        visited[src] = true;

        for( int dst=0; dst<matrix.length; dst++){

            if( matrix[src][dst] == 1 && visited[dst] == false){
                travel(dst, visited, matrix);
            }
        }
    }
}