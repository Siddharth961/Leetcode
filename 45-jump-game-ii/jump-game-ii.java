class Solution {
    public int jump(int[] nums) {
        int[]dp = new int[nums.length];
        int min = Integer.MAX_VALUE;

        for(int i=nums.length-2; i>=0; i--){
            if(i+nums[i]>=nums.length-1) dp[i] = 1;
            else if(nums[i]==0) dp[i]=-1;
            else{

                min = Integer.MAX_VALUE;
                for(int j=i+1; j<nums.length && j<=i+nums[i]; j++){
                    if(dp[j]==-1) continue;
                    min = Math.min(min, dp[j]);
                }

                if(min==Integer.MAX_VALUE) dp[i] = -1;
                else dp[i] = min+1;

            }
        }

        // for(int i:dp) System.out.print(i+" ");

        return dp[0];
    }
}