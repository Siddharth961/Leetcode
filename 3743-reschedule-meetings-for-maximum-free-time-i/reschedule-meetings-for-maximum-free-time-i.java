class Solution {
    public int maxFreeTime(int eventTime, int k, int[] start, int[] end) {
        
        ArrayList<Integer> al = new ArrayList<>();

        for(int i=0; i<start.length; i++){
            if(i == 0){
                al.add( start[i] );

            }

            else al.add( start[i] - end[i-1] );
        }

        al.add( eventTime -  end[ end.length-1 ]);

        // for(int i : al) System.out.print(i + " ");
        // System.out.println();
        int i=0;
        int j=0;

        int sum = 0;
        int ans = 0;


        while(j < al.size()){

            sum += al.get(j);
            if(j>k){
                sum -= al.get(i);
                i++;
            }

            // System.out.print(sum+" ");

            ans = Math.max( ans, sum );
            j++;
        }

        return ans;
    }
}