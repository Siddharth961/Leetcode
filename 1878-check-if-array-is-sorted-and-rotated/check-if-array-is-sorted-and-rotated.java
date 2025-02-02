class Solution {
    public boolean check(int[] nums) {
        
        int idx = -1;

        for(int i=1; i<nums.length; i++){
            if(nums[i-1] > nums[i]){
                idx = i;
                break;
            }
        }
        if(idx == -1) return true;

        for(int i=1; i<nums.length; i++){
            if(nums[ ((idx+i-1) % nums.length )] > nums[ (idx+i) % nums.length ]){
                return false;
            }
        } 

        return true;
    }
}