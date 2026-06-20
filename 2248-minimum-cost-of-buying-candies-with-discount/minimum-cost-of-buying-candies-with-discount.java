class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int ans = 0;

        int buy_count = 0;

        for(int i=cost.length-1; i>=0; i--){

            if(buy_count != 2){
                ans += cost[i];
                buy_count++;
            }
            else{
                buy_count = 0;
            }


        }

        return ans;
    }
}