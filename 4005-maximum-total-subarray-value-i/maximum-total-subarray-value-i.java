class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];

        for(int val : nums){
            min = Math.min(min, val);
            max = Math.max(max, val);
        }

        return 1L * (max - min) * k;
    }
}