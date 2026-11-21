class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        long min1 = Long.MAX_VALUE;
        long min2 = Long.MAX_VALUE;

        for(int val : nums){

            if(min1 == Long.MAX_VALUE){
                min1 = val;
                continue;
            }

            if( min2 != Long.MAX_VALUE && min2 < val){
                return true;
            }

            if( min1 >= val) min1 = val;
            else if( min2 == Long.MAX_VALUE || min2 > val ) min2 = val;
        }

        return false;
    }
}