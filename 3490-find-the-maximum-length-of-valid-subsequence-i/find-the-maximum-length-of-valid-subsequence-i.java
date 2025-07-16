class Solution {
    public int maximumLength(int[] nums) {
        // three posibilities
        // 1- all evens
        // 2- all odds
        // 3 - alternate even odss

        int len_even = 0;
        int len_odd = 0;
        int len_alt = 0;

        boolean prev_odd = nums[0] % 2 == 0; // for alt we wanna take first element in any case

        for(int i: nums){
            if( i % 2 == 0){
                len_even++;

                if( prev_odd == true){
                    len_alt++;
                    prev_odd = false;
                }
            }
            else{
                len_odd++;

                if(prev_odd == false){
                    len_alt++;
                    prev_odd = true;
                }
            }
        }

        return Math.max( len_alt, Math.max( len_even, len_odd));
    }
}