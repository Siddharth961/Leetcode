class Solution {
    public int specialArray(int[] nums) {
        
        

        for(int i=0; i<nums.length+1; i++){
            int count = 0;
            for(int j : nums){

                if(i<=j)count++;
            }

            if(count==i) return i;
        }


        return -1;

    }
}