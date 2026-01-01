class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int tank = 0;
        int i=0;
        int j=0;
        int n = gas.length;

        while(j < 2*n - 1){
            // System.out.print( i + " " + j + " " + " " + tank + " " );
            tank += gas[j%n] - cost[j%n];

            // if tank >= 0 we can reach j + 1..else no in thsat case we restart

            if(tank < 0){
                tank = 0;
                i = j+1; // we start from next stop
            }
            else{

                // we can start from i and reach j+1..now just check if we covered them all

                // System.out.print( ((j+1) - i  ));
                if( ((j+1) - i  )  == n) return i;

            }
                // System.out.println( );


            j++;

        }

        return -1;
    }
}