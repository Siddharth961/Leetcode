class Solution {
    public int minElement(int[] nums) {
        int ans = Integer.MAX_VALUE;

        for(int n : nums){

            int val = 0;

            while(n > 0){
                val += n % 10;
                n /= 10;

            }

            ans = Math.min(ans, val);
        }

        return ans;
    }
}