class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort( intervals, (a,b) -> Integer.compare(a[1], b[1]) );

        int ans = 0;
        int[]prev = new int[2] ;

        for(int[]arr : intervals){

            if( arr == intervals[0] ){
                prev = arr;
                continue;
            }

            if(arr[0]<prev[1]) ans ++;
            else prev = arr;

        }


        return ans;
    }
}