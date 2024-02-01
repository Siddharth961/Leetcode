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
        // sort(points);
        int[] arr = new int[points.length];
        for(int i=0; i<arr.length; i++) arr[i] = points[i][0];
        Arrays.sort(arr);

        int max = 0;

        for(int i=1; i<arr.length; i++){
            int x = arr[i] - arr[i-1];
            if(max<x) max = x;
        }

        return max;
    }
}