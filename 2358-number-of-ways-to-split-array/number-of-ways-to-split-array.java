class Solution {
    public int waysToSplitArray(int[] nums) {
        
        int n = nums.length;

        double[]pre = new double[n];

        pre[0] = nums[0]; 

        for(int i=1;  i<n; i++){
            pre[i] = nums[i] + pre[i-1]; 
        }

        int count = 0;

        for(int i=0; i<n-1; i++){
            if(pre[i] >= pre[n-1] - pre[i]) count++;
        }

        return count;

    }
}