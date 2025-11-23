class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        
        long zeroes1 = 0;
        long zeroes2 = 0;

        long sum1 = 0;
        long sum2 = 0;

        for(int i: nums1){
            sum1 += i;
            if(i == 0) zeroes1++;
        }
        for(int i: nums2){
            sum2 += i;
            if(i == 0) zeroes2++;
        }

        sum1 += zeroes1;
        sum2 += zeroes2;

        if(sum1 == sum2) return sum1;

        if( sum1 > sum2  && zeroes2 > 0) return sum1;
        if( sum2 > sum1  && zeroes1 > 0) return sum2;
        return -1;
    }
}