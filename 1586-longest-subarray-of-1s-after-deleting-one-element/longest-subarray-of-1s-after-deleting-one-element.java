class Solution {
    public int longestSubarray(int[] nums) {
        int i=0;
        int j=0;

        boolean deleted = false;

        int ans = 0;

        while(j<nums.length){

            while(deleted == true && nums[j]==0){
                if(nums[i]==0) deleted = false;
                i++;
            }

            if(nums[j]==0) deleted = true;

            int len = j-i+1;
            if(deleted==true) len--;

            ans = Math.max(ans, len);
            j++;            
        }

        if(ans==nums.length) ans--;

        return ans;

    }
}