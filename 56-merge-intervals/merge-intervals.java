class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort( intervals, (a,b) -> a[0] - b[0]);

        ArrayList<int[]>al = new ArrayList<>();

        int i=0;
        int j=1;

        while(j < intervals.length){

            if( intervals[i][1] >= intervals[j][0] ){
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1] );
            }

            else{
                al.add(intervals[i]);
                i = j;
            }

            j++;
        }

        al.add(intervals[i]);

        int[][]ans = new int[al.size()][];

        int idx = 0;
        for(int[]a : al){
            ans[idx] = a;
            idx++;
        }

        return ans;
    }
}