class Solution {
    public long countFairPairs(int[] nums, int lower, int upper){
        Arrays.sort(nums);

        long a = get_ans(nums, upper+1);
        long b = get_ans(nums, lower);

        // System.out.println(a);
        // System.out.println(b);

        return a - b;
    }

    public long get_ans(int[]nums, int tar){

        int i=0;
        int j=1;

        long ans = 0;

        while( j<nums.length ){

            while(i>=0 && nums[i]+nums[j] >= tar){
                i--;
            }
            if( i < 0) break;

            ans += i+1;
            i++;
            j++;

        }

        return ans;
    }
}