class Solution {
    public int findMin(int[] nums) {
        
        // divide and conquer
        // split array into parts

        // in a part if left < right -> it is sorted and min is left
        // if left == right || left > right -> we split it again

        return dnc(0, nums.length-1, nums);


    }

    public int dnc(int l, int r, int[]nums){

        if(l == r || nums[l] < nums[r]) return nums[l];

        int mid = (l+r)/2;

        return Math.min( dnc(l, mid, nums) , dnc(mid+1, r, nums));
    }
}