class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int ans = 0;
        int pro = 1;

        while(j<nums.length){
            pro *= nums[j];
            while(pro>=k && i<=j){
                pro /= nums[i];
                i++;
            }

            ans += j-i + 1; 
            j++;
        }

        return ans;
    }
}