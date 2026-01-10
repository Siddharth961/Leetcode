class Solution {
    public long minimumCost(long cost1, long cost2, long costBoth, long need1, long need2) {
        
        long ans = 0;

        if(costBoth <= cost1 + cost2){

            long min_val = Math.min(need1, need2);

            ans += costBoth * min_val;

            need1 = Math.max(0, need1 - min_val);
            need2 = Math.max(0, need2 - min_val);
        }

        if(costBoth <= cost1){

        // System.out.println(need1 + " " + need2);
            ans += need1 * costBoth;
            need2 = Math.max(0, need2 - need1);   
            need1 = 0;

            // System.out.println("here");         
        }

        if( costBoth <= cost2 ){
            ans += costBoth * need2;
            need1 = Math.max(0, need1 - need2);
            need2 = 0;
        }


        // System.out.println(need1 + " " + need2);

        ans += cost1 * need1 + cost2 * need2;

        return ans;
    }
}