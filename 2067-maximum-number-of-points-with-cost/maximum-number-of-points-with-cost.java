class Solution {
    public long maxPoints(int[][] points) {
        
        int n = points.length;
        int m = points[0].length;

        long[]prev = new long[m];
        long[]left = new long[m];
        long[]right = new long[m];

        for(int i=0; i<n; i++){
            if(i==0){
                for(int j=0; j<m; j++){
                    prev[j] = points[i][j];
                }
            }

            else{

                left[0] = prev[0];
                for(int j=1; j<m; j++){
                    left[j] = Math.max(left[j-1]-1, prev[j]);
                    
                }

                right[m-1] = prev[m-1];
                for(int j=m-2; j>=0; j--){
                    right[j] = Math.max( right[j+1]-1, prev[j]);
                }

                for(int j=0; j<m; j++){
                    prev[j] = points[i][j] + Math.max(left[j], right[j]);
                }
            }
        }

        long max = -1;

        for(int j=0; j<m; j++) max = Math.max(max, prev[j]);
        return max;
    }
}