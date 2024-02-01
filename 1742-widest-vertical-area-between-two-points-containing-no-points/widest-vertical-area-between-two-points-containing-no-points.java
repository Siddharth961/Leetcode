class Solution {
    static void sort(int[][]arr){
        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[]n1, int[]n2){
                if(n1[0]>n2[0]) return 1;
                else return -1;
            }
        });
    }
    public int maxWidthOfVerticalArea(int[][] points) {
        sort(points);
        int max = 0;

        for(int i=1; i<points.length; i++){
            int x = points[i][0] - points[i-1][0];
            if(max<x) max = x;
        }

        return max;
    }
}