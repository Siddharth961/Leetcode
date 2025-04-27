class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        
        long ans = 0;
        int small = -1;
        int big = -1;
        int wall = -1;

        for(int i=0; i<nums.length; i++){

            if(nums[i] == minK)small = i;
            if(nums[i] == maxK)big = i;

            if(nums[i]>maxK || nums[i]<minK) wall = i;

            ans += Math.max(0, Math.min(small, big) - wall);
        }

        return ans;
    }
}