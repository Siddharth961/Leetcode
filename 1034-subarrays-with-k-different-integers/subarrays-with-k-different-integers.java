class Solution {
    HashMap<Integer, Integer> mp = new HashMap<>();

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums,k) - atmost(nums, k-1);
    }

    public int atmost(int[]nums, int k){
        mp.clear();
        int i=0;
        int j=0;

        int[]count = new int[nums.length+1];
        int curr=0;
        int ans=0;

        while(j<nums.length){
            if(count[ nums[j] ]==0) curr++;
            count[ nums[j] ]++;

            while(curr>k && i<=j ){
                
                count[ nums[i] ]--;
                if(count[ nums[i] ] == 0) curr--;            
                i++;
            }
            ans += j-i+1;
            j++;
        }

        return ans;
    }
}