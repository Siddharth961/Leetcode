class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;

        int pro = 1;

        for(int i : nums){
            pro *= i;

            ans = Math.max(ans, pro);

            if(pro == 0) pro = 1;
        }

        pro = 1;

        for(int i=nums.length-1; i>=0; i--){
            pro *= nums[i];

            ans = Math.max(ans, pro);

            if(pro == 0) pro = 1;
        }

        return ans;
    }
}