class Solution {
    public void sortColors(int[] nums) {
        
        int i=0;
        int j=0;

        while(j<nums.length){
            if(nums[j]==0){
                nums[j] = nums[i];
                nums[i] = 0;
                i++;
               
            }
            j++;
        }

        j=i;
        
        while(j<nums.length){
            if(nums[j]==1){
                nums[j] = nums[i];
                nums[i] = 1;
                i++;
               
            }
            j++;
        }

        j=i; 

        while(j<nums.length){
            if(nums[j]==2){
                nums[j] = nums[i];
                nums[i] = 2;
                i++;
               
            }
            j++;
        }

    }
}