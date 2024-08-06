class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int mid = 0;

        while(l<=r){
            mid = (l+r)/2;
            // if(mid==0 && mid+1<nums.length && nums[mid]<nums[mid+1])return nums[mid];
            if(mid-1>=0 && nums[mid-1]>nums[mid]) return nums[mid];

            if(nums[mid]>nums[r]) l = mid+1;
            else  r = mid-1;
             
        }

        return nums[mid];
    }
}