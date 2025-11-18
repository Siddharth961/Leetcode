class Solution {
    public int removeDuplicates(int[] nums) {
        
        int i=0;
        int j=1;

        while(j<nums.length){

            if( nums[i] == nums[j]){

                if( i-1 < 0 || nums[i-1] != nums[i]){ // we dont already have two elements of same value
                        
                    i++;
                    nums[i] = nums[j];

                }
            }

            else{
                i++;
                nums[i] = nums[j];
            }

            j++;
        }

        return i+1;
    }
}