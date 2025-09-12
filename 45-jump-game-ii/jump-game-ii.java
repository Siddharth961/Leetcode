class Solution {
    public int jump(int[] nums) {
        
        // int[]dp = new int[nums.length];


        // for(int i=nums.length-2; i>=0; i--){
            
        //     int val = Integer.MAX_VALUE-1;
        //     for(int j=i+1; j<=i+nums[i] && j<nums.length; j++){

        //         val = Math.min(val, dp[j] + 1);

        //     }

        //     dp[i] = val ;

        // }

        // return dp[0];

        int farthest_point = 0;
        int next_point = 0;

        int i=0;
        int jumps = 0;

        while(i < nums.length){

            while(i<nums.length && i<=farthest_point){

                if(i == nums.length - 1) return jumps;
                next_point = Math.max(next_point, i + nums[i]);
                i++;
            }

            jumps++;

            if(next_point >= nums.length - 1) return jumps;

            farthest_point = next_point;
            next_point = 0;
        }

        return jumps;
    }
}