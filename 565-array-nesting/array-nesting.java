class Solution {
    public int arrayNesting(int[] nums) {

        boolean[]check = new boolean[nums.length];
        
        int ans = 0;
        for(int i : nums){
            // int val = get_ans(i, nums);
            if(check[i]==false)ans = Math.max(ans, get_ans(i, nums, check));
        }

        return ans;

    }

    public int get_ans(int val, int[]nums, boolean[]check){

        int idx = val;
        int count = 0;


        while(check[idx] != true ){
            check[idx] = true;
            idx = nums[idx];
            count++;
        }

        return count;
    }
}