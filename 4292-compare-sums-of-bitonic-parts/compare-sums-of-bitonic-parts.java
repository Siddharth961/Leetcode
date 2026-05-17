class Solution {
    public int compareBitonicSums(int[] nums) {
        

        long inc_sum = 0;
        long dec_sum = 0;

        boolean peak_occur = false;

        for(int i=0; i<nums.length; i++){

            if(i==0){
                inc_sum += nums[0];
                continue;
            }

            if(nums[i] > nums[i-1]) inc_sum += nums[i];
            else{

                if( !peak_occur ){
                    dec_sum += nums[i-1];
                    peak_occur = true;
                }

                dec_sum += nums[i];

            }
        }

        if(inc_sum > dec_sum) return 0;
        else if(inc_sum == dec_sum) return -1;
        else return 1;

    }
}