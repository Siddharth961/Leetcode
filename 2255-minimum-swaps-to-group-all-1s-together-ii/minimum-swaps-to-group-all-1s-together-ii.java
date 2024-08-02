class Solution {
    public int minSwaps(int[] nums) {
        
        int zeroes = 0;
        int swaps = 0;

        int ones = 0;
        for(int i : nums) if(i==1) ones++;

        int i = 0;
        int j=0;

        while(j <= i + ones -1){
            if(nums[j]==0) zeroes++;
            j++;
        }

        swaps  = zeroes;

        while(i < nums.length){

            j = j%nums.length;

            if(nums[j] == 0) zeroes++;
            if(nums[i] == 0) zeroes--;
            i++;

            if(swaps > zeroes) swaps = zeroes;
            j++;
        }

        return swaps;

    }
}