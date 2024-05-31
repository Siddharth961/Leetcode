class Solution {
    public int maxProduct(int[] nums) {

        // UNDERSTAND THIS CODE

        // int result = nums[0];
        // for(int i = 1; i < nums.length; i++)
        // {
        //     result = Math.max(result, nums[i]);
        // }
        // int max = 1;
        // int min = 1;
        // for(int i = 0; i < nums.length; i++)
        // {
        //     int temp = max;
        //     max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
        //     min = Math.min(nums[i], Math.min(temp * nums[i], min * nums[i]));
        //     result = Math.max(result, max);
        // }
        // return result;

        int pro = 1;
        int max = nums[0];

        for(int i=0; i<nums.length; i++){
            pro *= nums[i];
            max = Math.max(pro, max);
            if(pro==0) pro = 1;
        }

        pro = 1;

        for(int i=nums.length-1; i>=0; i--){
            pro *= nums[i];
            max = Math.max(pro, max);
            if(pro==0) pro = 1;
        }

        return max;       
    }
}