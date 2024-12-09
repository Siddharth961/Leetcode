class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        int[]pre = new int[n];
        int[]suf = new int[n];
        int[]ans = new int[n];

        pre[0] = nums[0];
        for(int i=1; i<n; i++) pre[i] = nums[i] * pre[i-1];

        suf[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--) suf[i] = nums[i] * suf[i+1];

        for(int i=0; i<n; i++){
            if(i == 0) ans[i] = suf[i+1];
            else if(i == n-1) ans[i] = pre[i-1];
            else{
                ans[i] = pre[i-1] * suf[i+1];
            }
        }

        return ans;
    }
}