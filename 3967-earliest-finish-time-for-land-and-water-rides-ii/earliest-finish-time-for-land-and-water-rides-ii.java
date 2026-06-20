class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int best_land_end = Integer.MAX_VALUE;
        int best_water_end = Integer.MAX_VALUE;

        for(int i=0; i<landStartTime.length; i++){
            
            best_land_end = Math.min(best_land_end, landStartTime[i] + landDuration[i]);

        }
        for(int i=0; i<waterStartTime.length; i++){
            
            best_water_end = Math.min(best_water_end, waterStartTime[i] + waterDuration[i]);

        }

        int ans = Integer.MAX_VALUE;


        for(int i=0; i<waterStartTime.length; i++){

            int val = best_land_end <= waterStartTime[i] ? waterStartTime[i] + waterDuration[i] : best_land_end + waterDuration[i];
            
            ans = Math.min(ans, val );
            
        }

        // System.out.println(ans);
        for(int i=0; i<landStartTime.length; i++){

            int val = best_water_end <= landStartTime[i] ? landStartTime[i] + landDuration[i] : best_water_end + landDuration[i];

            ans = Math.min(ans, val );
            
        }

        // System.out.println(ans);
        // System.out.println(best_land_end + " " + best_water_end);

        return ans;
    }
}