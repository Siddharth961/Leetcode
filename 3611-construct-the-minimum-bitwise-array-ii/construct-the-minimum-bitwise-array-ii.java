class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[]ans = new int[nums.size()];

        int idx = 0;
        for(int val : nums){
            ans[idx] = get_ans(val);
            idx++;
        }

        return ans;
    }

    public int get_ans(int val){

        if(val % 2 == 0) return -1;

        int minus = 1;
        int n = val/2;

        while(n%2 == 1){
            
            n /= 2;
            minus *= 2;
        }

        return val - minus;
    }
}