class Solution {
    public int[] singleNumber(int[] nums) {

        int xor = 0;

        for (int i : nums)
            xor = xor ^ i;

        int div = xor & -xor;

        int odd = 0;
        int even = 0;

        for (int i : nums) {
            if ( (i & div) != 0)
                odd = odd ^ i;
            else
                even = even ^ i;
        }

        int[] ans = { odd, even };
        return ans;
    }
}