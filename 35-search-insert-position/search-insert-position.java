class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int h = nums.length-1;
        int mid = 0;
        int idx = 0;

        while(l <= h){
            mid = (l+h)/2;

            if(nums[mid] == target) return mid;

            if(nums[mid] < target) l = mid+1;
            else{
                idx = mid;
                h = mid - 1;
            }
        }

        return l;
    }
}