class Solution {
    public int minOperations(int[] nums, int k) {

        if(k > (nums.length )/2) return -1;       

        
        int[]cost = new int[nums.length];

        for(int i=0; i<nums.length; i++){

            int left = 0;
            int right = 0;

            if(i == 0){
                left = nums[nums.length-1];
                right = nums[1];

            }

            else if(i == nums.length-1){
                left = nums[i-1];
                right = nums[0];
            }

            else{
                left = nums[i-1];
                right = nums[i+1];
            }

            cost[i] = Math.max(0, Math.max(left, right) + 1 - nums[i]);
        }

        int a = get_ans(0, nums.length-2, k, cost, nums);
        int b = get_ans(1, nums.length-1, k, cost, nums);

        int ans = Math.min(a, b);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    public int get_ans(int st, int en, int k, int[]cost, int[]nums){

        int len = en - st + 1;

        if(k > (len+1)/2) return Integer.MAX_VALUE; // not possible
        int[][]dp = new int[len+1][k+1]; //[i][j] stores cost of making j peaks - among first i elements

        for(var a : dp)Arrays.fill(a, Integer.MAX_VALUE);

        // cost of making zero peaks is zero
        for(int i=0; i<=len; i++){

            dp[i][0] = 0;

        }

        for(int i=1; i<=len; i++){
            for(int j=1; j<=k; j++){

                // not making this element peak -- but still needs j peak

                int no_take = dp[i-1][j]; // note that it can be Integer.MAX_VALUE if it is not possible

                // making this element a peak

                int prev = Integer.MAX_VALUE;

                if(i >= 2)prev = dp[i-2][j-1]; // cost of making j-1 peak among i-2 elements..since cant make consecutive peaks
                else if(j==1){
                    // prev = dp[0][j-1];
                    prev = 0;
                    // System.out.println(prev + " "+j);
                }

                int take = 0;

                if(prev != Integer.MAX_VALUE) take = prev + cost[st + i - 1];
                else take = Integer.MAX_VALUE; // if it is impossible to get j-1 peaks among i-1, it is impossible to get j peaks among i elements

                dp[i][j] = Math.min(no_take, take);

                // System.out.println(dp[i][j]);



            }

        }

        return dp[len][k];
        
    }
}