class Solution {
    public int findMaxK(int[] nums) {
        int[]arr = new int[1001];

        for(int i:nums) if(i<0) arr[-1*i] = 1;

        int ans = -1;

        for(int i : nums) if(i>0 && arr[i]==1 && ans<i) ans = i;

        return ans;
    }
}