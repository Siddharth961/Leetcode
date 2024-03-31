class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int min = -1;
        int max = -1;
        long ans = 0;
        int wall = -1;

        for(int i=0; i<nums.length; i++){

            if(nums[i]<minK || nums[i]>maxK) wall = i;
            if(nums[i] == minK) min = i;
            if(nums[i] == maxK) max = i;

            ans += Math.max(0, Math.min( min, max ) - wall);
        }

        return ans;
    }
}