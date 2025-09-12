class Solution {
    public int search(int[] nums, int target) {
        
        int pivot = 0;
        int l=0;
        int h=nums.length-1;
        int mid=0;

        while( l <= h ){

            mid = (l+h)/2;

            if( nums[mid] >= nums[0]){
                l = mid+1;
            }
            else{
                pivot = mid;
                h = mid-1;
            }

        }

        int ans = search(0, pivot-1, nums, target);

        if(ans != -1) return ans;

        return search(pivot, nums.length-1, nums, target);

    }

    public int search(int l, int h, int[]nums, int tar){

        int mid = 0;

        while(l <= h){
            mid = (l+h)/2;

            if(nums[mid] == tar) return mid;

            if(nums[mid] < tar) l = mid+1;
            else h = mid-1;
        }

        return -1;
    }
}