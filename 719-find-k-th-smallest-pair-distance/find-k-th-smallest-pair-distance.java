class Solution {
    public int smallestDistancePair(int[] nums, int k) {

        int min = Integer.MAX_VALUE;
        int max = -1;

        for(int i : nums){
            if(min > i) min = i;
            if(max < i) max = i;
        }

        int[]freq = new int[ max-min + 1];
        int val=0;

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                val = Math.abs(nums[i]-nums[j]);
                freq[val]++;
            }
        }

        for(int i=0; i<freq.length; i++){
            k -= freq[i];
            if(k <= 0 ) return i;
        }
        return -1;
    }
}