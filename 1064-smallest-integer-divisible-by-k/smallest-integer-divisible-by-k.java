class Solution {
    public int smallestRepunitDivByK(int k) {
        
        int digits = 1;
        int rem = 0;

        while(digits <= k){

            rem = ((rem * 10) + 1) % k;

            if(rem == 0) return digits;
            digits++;

        }

        return -1;
    }
}