class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n;
        
        reverse(0, n - k - 1, nums);
        reverse(n - k, n - 1, nums);
        reverse(0, n-1, nums);

    }

    public void reverse(int l, int h, int[]nums){

        while(l < h){
            int temp = nums[l];
            nums[l] = nums[h];
            nums[h] = temp;

            l++;
            h--;
        }
    }
}