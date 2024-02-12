class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==1) return nums[0]==target ? 0 : -1;
        int l = 0;
        int h = nums.length - 1;
        int mid = 0;

        int smallest = 0;

        if(nums[l]<nums[h]) smallest = l;

        else{
            while(l<=h){
            mid = (l+h)/2;
            if(mid-1>=0 && nums[mid-1] > nums[mid]){
                smallest = mid;
                break;
            }
            else if( nums[mid] > nums[h]) l = mid + 1;
            else h = mid - 1;
            }
        }

        if(nums[smallest] == target) return smallest;

        if(target <= nums[nums.length-1]){
            l = smallest + 1;
            h = nums.length-1;
        }
        else{
            l = 0;
            h = smallest - 1;
        }

        

        while(l<=h){
            mid = (l+h)/2;
            if(nums[mid]==target) return mid;
            else if( nums[mid] < target) l = mid+1;
            else h = mid-1;
        }

        return -1;
    }
}