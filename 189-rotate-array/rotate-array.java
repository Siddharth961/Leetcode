class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverse(0, nums.length-1, nums);
        reverse(0, k-1, nums);
        reverse(k, nums.length-1, nums);

    }

    public void reverse(int st, int en, int[]nums){
        int temp = 0;
        while(st<=en){
            temp = nums[st];
            nums[st] = nums[en];
            nums[en] = temp;

            st++;
            en--;
        }
    }
}