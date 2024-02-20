class Solution {
    public int missingNumber(int[] nums) {
        int idx = 0;
        boolean isZero = false;

        for(int i  = 0; i<nums.length; i++){

            if(nums[i]==0){
                isZero = true;
                continue;
            }

            if(nums[i]>0) idx = nums[i] - 1;
            else idx = nums[i]*-1 - 1;

            if(idx>=nums.length) continue;

            if(nums[idx]>0) nums[idx] = nums[idx]*-1;
            else if(nums[idx]==0) {
                isZero = true;

                nums[idx]=-nums.length-1; 
            }
            
        }        
           


        if(isZero==false) return 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i]>=0) return i+1;
        }

        return -1;
    }
}