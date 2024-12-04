class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int j=1;
        while(j<nums.length){
            if(nums[i] != nums[j]){
                nums[i+1] = nums[j];
                i++;
            }
            else{
                if(i==0 || nums[i-1] != nums[i]){
                    nums[i+1] = nums[j];
                    i++;
                }
            }

            j++;
        }

        return i+1;
    }
}