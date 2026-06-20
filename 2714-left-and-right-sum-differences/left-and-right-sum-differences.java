class Solution {
    public int[] leftRightDifference(int[] nums) {
        
        int[]ans = new int[nums.length];

        int left=0;

        for(int i=0; i<ans.length; i++){

            ans[i] = left;
            left += nums[i];

        }

        int right = 0;

        for(int i=ans.length-1; i>=0; i--){

            ans[i] = Math.abs(ans[i] - right);
            right += nums[i];
        }

        return ans;
    }
}