class Solution {
    public int maxProduct(int[] nums) {
        
        int ans = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            int pro = 1;

            for(int j=i; j<nums.length; j++){

                pro *= nums[j];
                if(ans<pro) ans = pro;
                if(pro==0) break; 
            }
            
        }

        return ans;
    }
}