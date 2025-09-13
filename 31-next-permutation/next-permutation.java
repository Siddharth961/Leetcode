class Solution {
    public void nextPermutation(int[] nums) {
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] < nums[i+1]){

                int j=i+1;

                for(; j<nums.length; j++){
                    if(nums[j] <= nums[i]) break;
                }

                j--;

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                sort(i+1, nums);

                return ;
            }
        }

        for(int i=0; i<nums.length/2; i++){

            int temp = nums[i];
            nums[i] = nums[ nums.length - i - 1];
            nums[ nums.length - i - 1] = temp;
        }
    }

    public void sort(int idx, int[]nums){

       int i=idx;
       int j=nums.length -1;

       while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
       }
    }
}

//  1 3 2 1
//  2 1 3 1 X
//  2 1 1 3

//  2 6 5 4 3 0
//  3 2 