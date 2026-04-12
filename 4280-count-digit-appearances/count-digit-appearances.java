class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        
        int ans = 0;

        for(int val : nums){
            while(val > 0){
                if(val % 10 == digit) ans++;
                val /= 10;
            }
        }

        return ans;
    }
}