class Solution {
    public void moveZeroes(int[] nums) {
        int i=0; 
        int j=nums.length-1;

        while(i < nums.length){

            if(nums[i] == 0){

                j = i;

                while(j<nums.length && nums[j] == 0) j++;

                if(j == nums.length) break;

                nums[i] = nums[j];
                nums[j] = 0;
            }

            i++;
        }
    }
}