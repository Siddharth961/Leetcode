class Solution {
    public boolean canJump(int[] nums) {
        
        int jump_required = 0;

        for(int i=nums.length-2; i>=0; i--){

            jump_required++;

            if(jump_required <= nums[i]) jump_required = 0;
        }

        return jump_required == 0;

    }
}