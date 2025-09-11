class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[]ans = new int[2];

        ans[0] = getIdx(0, nums, target);
        ans[1] = getIdx(1, nums, target);

        return ans;
    }

    public int getIdx(int type, int[]nums, int tar){

        int ans = type == 0 ?  nums.length : -1;

        int l=0;
        int h=nums.length-1;

        int mid = 0;

        while(l <= h){

            mid = (l+h)/2;

            int val = nums[mid];

            // System.out.println(l+ " " + mid + " "+ h);

            if(val < tar){
                l = mid+1;
            }       
            else if(val == tar){

                if(type == 0){
                    ans = Math.min( ans, mid);

                    h = mid-1;
                }
                
                if(type == 1){
                    ans = Math.max( ans, mid);

                    l = mid+1;
                }
                
            }   

            else{
                h = mid-1;
            }  

        }

        return ans == nums.length ? -1 : ans;
    }
}