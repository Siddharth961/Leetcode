class Solution {
    public int singleNumber(int[] nums) {
        int num = 0;       

        int temp = 0;
        int count = 0;

        for(int i=0; i<32; i++){

            temp = ( 1 << i);

            count = 0;

            for(int j=0; j<nums.length; j++){

                if( (nums[j] & temp) != 0) count++;
                
            }

            if(count%3 == 1){
                num = (num | temp);
            }

        }

        return num;
    }
}