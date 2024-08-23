class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][]dp = new int[n][n];
        return get_ans(0, n-1, s.toCharArray(), dp);
    }

    public int get_ans(int l, int r, char[]arr, int[][]dp){

        if(l==r) return 1;
        if(l>r) return 0;

        if(dp[l][r] != 0) return dp[l][r];

        int i=l;
        while(i<arr.length && arr[i]==arr[l]) i++;

        if(i==arr.length) return 1;

        int base_ans = 1 + get_ans(i, r, arr, dp);
        int adv_ans = Integer.MAX_VALUE;

        int j=i;

        for(; j<arr.length; j++){

            if(arr[j]==arr[l]){
                adv_ans = Math.min( adv_ans, get_ans(i, j-1, arr, dp) + get_ans(j, r, arr, dp));
            }

        }

        int ans = Math.min(base_ans, adv_ans);
        dp[l][r] = ans;

        return ans;
    }
}