class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for(int i:nums) if(max<i) max = i;


        long less_than_k = atmost(nums, max, k);


        return less_than_k;

        // return 0;
    }

    public long atmost(int[]nums, int val, int k){
        int i=0;
        int j=0;
        long ans = 0;

        int curr = 0;

        while(j<nums.length || i>j){
            if(nums[j]==val) curr++;

            while(curr>=k ){
                // ans_avail = true;
                if(nums[i]==val) curr--;
                i++;
                ans += nums.length-j;
            }

            j++;
        }

        return ans;
    }

}