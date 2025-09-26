class Solution {
    public void moveZeroes(int[] nums) {
        int i=0; 
        int j=0;

        while(j < nums.length){

            if(nums[j] != 0 && i != j){

                // j = i;


                // if(j == nums.length) break;

                // nums[i] = nums[j];
                // nums[j] = 0;
                while(i<j && nums[i] != 0) i++;

                if(i != j){

                    nums[i] = nums[j];
                    nums[j] = 0;
                    i++;
                }

            }

            j++;
        }
    }
}