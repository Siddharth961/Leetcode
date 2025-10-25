class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]>ll = new LinkedList<>();

        int i = 0;

        // if(intervals.length == 0 || newInterval[1] < intervals[0][1]) ll.add(newInterval);
        int end = -1;

        while(i < intervals.length){

            if( end < newInterval[0] && newInterval[1] < intervals[i][0]){
                ll.add(newInterval);
                end = newInterval[1];
            }

            if( overlap(intervals[i] , newInterval) ){

                intervals[i][0] = Math.min(intervals[i][0], newInterval[0]);
                intervals[i][1] = Math.max(intervals[i][1], newInterval[1]);
                
            // System.out.println(intervals[i][0] + " " + intervals[i][1]);
            }


            if(ll.size() == 0){
                ll.add(intervals[i]);

                end = intervals[i][1];
                i++;
                continue;
            }

            int[]prev = ll.get(ll.size()-1);

            if( overlap(prev, intervals[i]) ){

                    prev[0] = Math.min(prev[0], intervals[i][0]);
                    prev[1] = Math.max(prev[1], intervals[i][1]);
            }

            else ll.add(intervals[i]);

            end = ll.get(ll.size()-1)[1];

            i++;

        }
        // int[]prev = ll.get(ll.size()-1);

        if(ll.size() == 0 || ll.get(ll.size()-1)[1] < newInterval[0]) ll.add(newInterval);

        // for(int[]a : ll) System.out.println(a[0] + " " + a[1]);

        int[][]ans = new int[ll.size()][];

        int idx = 0;
        for(int[] a : ll){
            ans[idx] = a;
            idx++;
        }

        return ans;
    }

    public boolean overlap(int[]a, int[]b){

        // check if a's start point is between start and end of b
        // check if a's end point is between start and end of b

        return ( (a[0] >= b[0] && a[0] <= b[1]) || ( a[1] >= b[0] && a[1] <= b[1]) );
    }
}