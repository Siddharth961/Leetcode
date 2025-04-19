class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;

        // Safe subarray count
        long total_subarray = (long) n * (n + 1) / 2;

        long discard_subarray = atmost(nums, k - 1);

        return total_subarray - discard_subarray;
    }

    public long atmost(int[] nums, int k) {
        int i = 0;
        int j=0;
        long ans = 0;
        long pairs = 0;

        HashMap<Integer, Integer> mp = new HashMap<>();

        while(j < nums.length) {

            int freq = mp.getOrDefault(nums[j], 0);
            pairs += freq;
            mp.put(nums[j], freq + 1);

            while (pairs > k) {
                int val = mp.get(nums[i]);
                pairs -= (val - 1);
                if (val == 1) {
                    mp.remove(nums[i]);
                } else {
                    mp.put(nums[i], val - 1);
                }
                i++;
            }

            ans += j - i + 1;
            j++;
        }

        return ans;
    }
}
