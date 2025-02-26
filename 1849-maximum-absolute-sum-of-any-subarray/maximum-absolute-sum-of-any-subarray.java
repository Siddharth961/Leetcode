class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max_sum = 0;
        int min_sum = 0;

        int s_max = 0;
        int s_min = 0;

        for(int i : nums){
            s_max += i;

            if(s_max < 0) s_max = 0;
            max_sum = Math.max(max_sum, s_max);

            s_min += i;

            if(s_min > 0) s_min = 0;
            min_sum = Math.min(min_sum, s_min);
        }

        return Math.max(max_sum, -min_sum);
    }
}