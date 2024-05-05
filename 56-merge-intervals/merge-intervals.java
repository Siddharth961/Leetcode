class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> al = new ArrayList<>();

        int i=0;
        int j=0;
        int start = 0;
        int end=0;

        while(i < intervals.length){

            start = intervals[i][0];

            end = intervals[i][1];

            if(i+1 < intervals.length && end>= intervals[i+1][0]){

                while(i+1 < intervals.length && end>= intervals[i+1][0]){
                    end = Math.max(end, intervals[i+1][1]);
                    i++;
                }

                int[] arr = new int[2];
                arr[0] = start;
                arr[1] = end;
                
                al.add( arr );
            }
            else{
                al.add(intervals[i]);
                
            }

            i++;

        }

        int[][]ans = new int[al.size()][];

        int idx = 0;

        for(int[] arr : al){
            ans[idx] = arr;
            idx++;
        }


        return ans;
    }
}