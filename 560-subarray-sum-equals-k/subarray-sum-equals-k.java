class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        int ans = 0;

        int pre = 0;
        for(int i : nums){
            pre += i;

            if(mp.containsKey( pre - k)){
                ans += mp.get(pre - k);
            }

            if(pre == k) ans++;
            mp.put( pre , mp.getOrDefault(pre, 0) + 1);

        }

        return ans;
    }
}