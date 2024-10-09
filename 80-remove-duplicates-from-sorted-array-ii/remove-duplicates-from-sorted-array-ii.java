class Solution {
    public int removeDuplicates(int[] nums) {
        int end = nums.length;

        int i=0;

        for( i=2; i<end; i++){
            if( nums[i] == nums[i-1] && nums[i]==nums[i-2]){
                swap(i, end, nums);
                end--;
                i--;
            }

        }

        return i;

    }

    public void swap(int i, int end, int[]nums){
        int temp = 0;
        for(; i<end-1; i++){
            temp = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = temp;
        }
    }
}