class Solution {
    public int majorityElement(int[] nums) {
        
        int candi = nums[0];
        int freq = 1;

        for(int i=1; i<nums.length; i++){

            if(nums[i] == candi) freq++;
            else{
                freq--;
                if(freq<0){
                    candi = nums[i];
                    freq = 1;
                }
            }
        }

        return candi;
    }
}