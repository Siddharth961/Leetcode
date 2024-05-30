class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        int j=i+k-1;
        int min = Integer.MAX_VALUE;
        

        while(j<nums.length){
            min = Math.min( min, nums[j]-nums[i]);
            j++;
            i++;
        }

        return min;
    }
}