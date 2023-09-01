class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int val = (n*(n+1))/2;

        int[]ans = new int[2];
        HashSet<Integer> st = new HashSet<>();

        for( int i : nums){
            if(st.contains(i)){
                ans[0] = i;
            }

            else{
                st.add(i);
                val = val - i;
            }
        }

        ans[1] = val;

        return ans;
    }
}