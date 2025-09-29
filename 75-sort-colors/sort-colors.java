class Solution {
    public void sortColors(int[] nums) {
        
        int l=0; // start of 0s
        int mid = 0; // start of 1s
        int h=nums.length-1; // start of 2s

        while(mid <= h){

            if(nums[mid] == 0){

                nums[mid] = nums[l];
                nums[l] = 0;
                l++;
                mid++;
            }
            else if(nums[mid] == 2){

                nums[mid] = nums[h];
                nums[h] = 2;
                h--;

            }
            else{
                mid++;

            }
        }
    }
}
