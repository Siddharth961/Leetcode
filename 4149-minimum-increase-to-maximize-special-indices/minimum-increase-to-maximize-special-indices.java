class Solution {
    long[][]dp ;
    public long minIncrease(int[] nums) {

        dp = new long[nums.length][2];
        for(var a : dp) Arrays.fill(a, -1);

        return get_ans(1, 0, nums);
    }

    public long get_ans(int idx, int dropped, int[]nums){

        if(idx >= nums.length - 1){
            return 0;
        }



        // if odd length we will only take element and every alternate element from 1..n-1
        // if even length..between 1..n-1 we are gonna take alternate elements BUT at some point instead of taking current element we can take just next element and continue taking alternate elements then forth .. we can do this only ONCE

        // since we are gonna maximise elements taken to utmost value in any case.. we are not gonna track it
        // we will track only operations needed


        if(dp[idx][dropped] != -1) return dp[idx][dropped];



        long ans = 0; // no of operations

        long a = 0;
        long b = Long.MAX_VALUE;

        // take

        int val_needed = 1 +  Math.max(nums[idx-1] , nums[idx+1]) ;

        a = Math.max(0, val_needed - nums[idx] );
        a += get_ans(idx+2, dropped, nums);
        // System.out.println(idx + " " + a);

        // no take

        if(nums.length%2 == 0 && dropped == 0){

            b = get_ans(idx+1, 1, nums);
        }

        ans = Math.min(a, b);

        dp[idx][dropped] = ans;

        return ans;

        
    }
}