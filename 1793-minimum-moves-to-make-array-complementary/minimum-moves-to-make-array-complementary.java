class Solution {
    public int minMoves(int[] nums, int limit) {
        
        int i=0;
        int j=nums.length-1;

        int[]diff = new int[2*limit + 2];

        while(i < j){

            int min = Math.min(nums[i], nums[j]);
            int max = Math.max(nums[i], nums[j]);

            int min_val = min + 1;
            int max_val = max + limit;

            // 2 moves - initially everywhere but will be overwritten
            diff[2] += 2;
            diff[diff.length-1] -= 2;

            // 1 move ( doing -1 instead of +1 as already have put 2 moves everywhere - need to reduce it to 1)
            diff[min_val] += -1;
            diff[max_val + 1] -= -1;

            // 0 move - will be in range only

            diff[min+max] += -1;
            diff[min+max+1] -= -1;

            i++;
            j--;


        }

        int ans = Integer.MAX_VALUE;

        for( i=2; i<= 2*limit; i++){

            diff[i] = diff[i-1] + diff[i];

            ans = Math.min(ans, diff[i]);
        }

        return ans;
    }
}