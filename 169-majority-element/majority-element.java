class Solution {
    public int majorityElement(int[] nums) {
        int candi = nums[0];
        int count = 1;

        for(int i=1; i<nums.length; i++){
            if(nums[i] != candi){
                if(count == 0){
                    candi = nums[i];
                    count = 1;
                }
                else count--;
            }
            else count++;
        }

        count = 0;
        for(int i : nums) if(i==candi) count++;

        if(count> (nums.length/2)) return candi;
        return -1;


    }
}