class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        int i = 0;
        int j = nums.length-1;
        int mid = 0;

        while(i<=j){
            mid = (i+j)/2;
            

            if(mid > 0 && nums[mid-1]>nums[mid]) j = mid-1;
            else if(mid < nums.length-1 && nums[mid]<nums[mid+1]) i = mid+1;
            else return mid;

        }

        return mid;
    }
}