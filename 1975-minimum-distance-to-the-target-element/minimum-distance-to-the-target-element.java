class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        
        int ans = nums.length + 1;

        for(int i=start; i<nums.length; i++){
            if(nums[i] == target){
                ans = Math.min(ans, Math.abs(i - start));
                break;
            }
        }

        
        for(int i=start; i>=0; i--){
            if(nums[i] == target){
                ans = Math.min(ans, Math.abs(i - start));
                break;
            }
        }

        return ans == nums.length + 1 ? -1 : ans;
    }
}