class Solution {
    public int smallestDistancePair(int[] nums, int k) {

        Arrays.sort(nums);

        int hi = nums[nums.length-1] - nums[0];
        int lo = 0;

        int mid = 0;

        int val = 0;
        int candi = 0;

        while(lo<=hi){
            mid = (lo+hi)/2;
            val = check(mid, nums);

            // if( val == k ) return mid;
            // else if(val > k) hi = mid-1;
            // else lo = mid+1;

            if(val < k) lo = mid+1;
            else{
                candi = mid;
                hi = mid-1;
            }
        }
        return candi;
    }

    public int check(int tar, int[]nums){
        int i=0;
        int j=1;

        int ans = 0;
        int val = 0;

        while( j < nums.length){

            while(nums[j] - nums[i] > tar){
                i++;
                
            }
            ans += j-i;

            j++;           
        }

        return ans;
    }
}