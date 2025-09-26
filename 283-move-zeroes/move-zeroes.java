class Solution {
    public void moveZeroes(int[] nums) {
        int i=0; 
        int j=0;

        while(j < nums.length){

            if(nums[j] != 0){

                // j = i;

                // while(j<nums.length && nums[j] == 0) j++;

                // if(j == nums.length) break;

                // nums[i] = nums[j];
                // nums[j] = 0;

                nums[i] = nums[j];
                // nums[j] = 0;
                i++;
            }

            j++;
        }

        while(i<nums.length){
             nums[i] = 0;
             i++;
        }
    }
}