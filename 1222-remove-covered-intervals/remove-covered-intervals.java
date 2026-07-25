class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> {
            if(a[0] != b[0]){
                return a[0] - b[0];
            }
            else return b[1] - a[1];
        });

        int removed = 0;

        int st = 0;
        int en = 0;

        for(int[]arr : intervals){

            if( st <= arr[0]  && en >= arr[1]) removed++;
            else{
                st = arr[0];
                en = arr[1];
            }
        }

        return intervals.length - removed;
    }
}