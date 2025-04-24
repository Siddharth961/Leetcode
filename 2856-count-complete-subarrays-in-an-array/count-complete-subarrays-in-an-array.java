class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        int n = nums.length;

        for(int i : nums) st.add(i);

        int discard = atmost(st.size(), nums);

        int total = ( n * (n+1) ) / 2;

        return total - discard;
    }

    public int atmost( int k, int[]nums){

        HashMap<Integer, Integer> mp = new HashMap<>();

        int i=0;
        int j=0;
        int ans = 0;

        while(j < nums.length){

            mp.put( nums[j], mp.getOrDefault(nums[j], 0) + 1);

            while(mp.size() >= k){

                if(mp.get(nums[i]) == 1){
                    mp.remove(nums[i]);
                }
                else mp.put(nums[i], mp.get(nums[i]) - 1);

                i++;
            }

            ans += j - i + 1;
            j++;
        }

        return ans;
    }
}