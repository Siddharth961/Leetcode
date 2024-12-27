class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int total_gas = 0;
        int total_cost = 0;

        for(int i=0; i<gas.length; i++){
            total_gas += gas[i];
            total_cost += cost[i];
        }

        if(total_cost > total_gas) return -1;

        int ans = 0;
        int curr_gas = 0;

        for(int i = 0; i<gas.length; i++){


            if(curr_gas < 0){
                ans = i;
                curr_gas = 0;
            }

            curr_gas += gas[i] - cost[i];
            

            
        }

        return ans;
    }
}