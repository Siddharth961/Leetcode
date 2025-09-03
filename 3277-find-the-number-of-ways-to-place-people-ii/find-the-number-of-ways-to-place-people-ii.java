class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a , b) -> {
            if( a[0] == b[0]){
                return b[1] - a[1];
            }

            return a[0] - b[0];
        });

        int pairs = 0;

        int i=0;
        int j=1;

        while( i < points.length){

            j = i+1;
            long prevY = Long.MIN_VALUE;

            while( j < points.length){
                if( points[i][1] >= points[j][1] && prevY < points[j][1]){
                    pairs++;
                    prevY = points[j][1];
                }
                j++;
            }

            i++;
        }

        return pairs;
    }
}