class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> st = new HashSet<>();

        int i=0;
        int j=0;

        int sum = 0;
        int ans = 0;

        while(j < nums.length){

            while( st.contains(nums[j]) ){
                st.remove( nums[i] );
                sum -= nums[i];

                i++;
            }

            sum += nums[j];
            st.add(nums[j]);

            ans = Math.max(ans, sum);
            j++;
        }

        return ans;
    }
}