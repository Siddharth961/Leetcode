class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        int i = 0;
        int jumps = 0;

        while(i<nums.length){
            if(i>=n-1) return jumps;

            if(i+nums[i]>=nums.length-1) return jumps+1;

            int max = 0;
            int temp = 0;
            for(int j=1; j<=nums[i]; j++){

                int jump2 = j + nums[i+j];
                
                if(max<jump2){
                    max = jump2;
                    temp = j;
                }
            }
            
            i += temp;
            jumps++;
        }

        return jumps;
    }
}