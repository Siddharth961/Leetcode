class Solution {
    public boolean isTrionic(int[] nums) {
        
        int j=1;

        boolean first = false;
        boolean second = false;
        boolean third = false;
        while(j<nums.length){

            if(nums[j-1] < nums[j] && second == false){
                first = true;
            }
            else if( nums[j-1] > nums[j] && first == true && third == false){
                second = true;
            }
            else if(nums[j-1] < nums[j] && second == true){
                third = true;
            }
            else return false;

            j++;
        }

        return j == nums.length && first && second && third;
    }
}