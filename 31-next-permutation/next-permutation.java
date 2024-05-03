class Solution {
    public void nextPermutation(int[] nums) {

        int i=0;
        
        for( i=nums.length-2; i>=0; i--){

            if(nums[i]<nums[i+1]){
                break;
            }
        }

        if(i >= 0){
            int min = 200;
            int idx = -1;

            for(int j=i+1; j<nums.length; j++){
                if(nums[j] > nums[i] && nums[j]<min){
                    min = nums[j];
                    idx = j;
                }
            }

            nums[idx] = nums[i];
            nums[i] = min;


            Arrays.sort(nums, i+1, nums.length);
        }

        else Arrays.sort(nums);


        
    }
}