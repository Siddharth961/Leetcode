class Solution {
    public int missingNumber(int[] nums) {
        
        int mark = nums.length + 1;

        for(int i : nums){

            int idx = i % mark;

            if(idx < nums.length) nums[idx] += mark;
        }

        // for(int i : nums) System.out.print(i + " ");

        for(int i=0; i<nums.length; i++){
            if( nums[i] <= nums.length) return i;
        }

        return nums.length;
    }
}