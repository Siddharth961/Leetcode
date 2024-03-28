class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0;
        int i = 0;
        int j = 0;

        HashMap<Integer, Integer> mp = new HashMap<>();

        while(j<nums.length){
            mp.put( nums[j], mp.getOrDefault(nums[j], 0) + 1);

            while(mp.get(nums[j]) > k && i<=j){
                mp.put(nums[i], mp.get(nums[i])-1 );
                i++;
            }
            if(ans < j-i+1) ans = j-i+1;
            j++;
        }

        return ans;
    }
}