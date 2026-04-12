class Solution {
    public int rob(int[] nums) {

        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int a = check(0, nums.length-2, nums);
        int b = check(1, nums.length-1, nums);

        return Math.max(a, b);
        
    }

    public int check(int st, int en, int[]nums){

        int prev_taken = 0;
        int prev_not_taken = 0;

        for(int i=st; i <= en; i++){

            // taking this house

            int temp = prev_not_taken + nums[i];

            // not taking

            int temp2 = Math.max(prev_taken, prev_not_taken);

            prev_taken = temp;
            prev_not_taken = temp2;
        }

        return Math.max(prev_taken, prev_not_taken);
    }

    
}