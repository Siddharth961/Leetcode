class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        
        long peri = 0;
        long csum = 0;

        for(int i = 0; i<nums.length; i++){
            if(i<2){
                csum += nums[i];
                continue;
            }
            if(nums[i]<csum){
                csum += nums[i];
                peri = csum;
                continue;
            }

            csum += nums[i];
            
        }

        


        if(peri > 0) return peri;

        return -1;
    }
}