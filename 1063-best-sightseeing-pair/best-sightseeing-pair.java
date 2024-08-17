class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        int max = values[0]-1;
        int ans = 0;

        for(int i = 1; i<values.length; i++){
            int val = max + values[i];
            ans = Math.max(ans, val);
            if(max < values[i]) max = values[i];
            max --;
        }

        return ans;
    }
}