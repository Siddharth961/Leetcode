class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmost(nums, goal) - atmost(nums, goal-1);
    }
    public int atmost(int[]nums, int goal){
        int ans = 0;
        int i = 0;
        int j = 0;
        int sum = 0;

        while(j<nums.length){
            sum+=nums[j];
            while(sum>goal && i<=j){
                sum -= nums[i];
                i++;
            }
            ans += j-i+1;
            j++;
        }
        return ans;
    }
}