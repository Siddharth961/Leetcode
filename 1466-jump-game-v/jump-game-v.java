class Solution {
    int[]dp ;
    public int maxJumps(int[] arr, int d) {

        dp = new int[arr.length];

        Arrays.fill(dp, -1);
        int ans = 0;

        for(int i=0; i<arr.length; i++){
            
            int val = get_ans(i, d, arr);

            ans = Math.max(ans, val);
        }

        return ans;

        
    }

    public int get_ans(int idx, int d, int[]arr){

        if(dp[idx] != -1) return dp[idx];

        int ans = 1;

        int l = Math.max(0, idx - d);
        int h = Math.min(arr.length-1, idx + d);

        for(int j = idx-1; j >= l; j--){

            if(arr[j] >= arr[idx]) break;

            int val = get_ans(j, d, arr);

            ans = Math.max(ans, val + 1);
        }

        for(int j = idx+1; j <= h; j++){

            if(arr[j] >= arr[idx]) break;

            int val = get_ans(j, d, arr);

            ans = Math.max(ans, val + 1);
        }

        dp[idx] = ans;

        return ans;


    }
}
