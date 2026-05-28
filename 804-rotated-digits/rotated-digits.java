class Solution {
    static int[]arr = new int[]{0 , 1, 8, 2, 5, 6, 9};

    int[][][]dp ;
    public int rotatedDigits(int n) {

        dp = new int[n][2][2];

        for(int[][]a : dp) for(int[]b : a) Arrays.fill(b, -1);

        return digiDP(0, 1, 0, n+"");
        
    }

    public int digiDP( int idx, int tight, int used_diff_rot, String n){

        if(idx == n.length()){
            if(used_diff_rot == 1) return 1;
            return 0;
        }


        if(dp[idx][tight][used_diff_rot] != -1) return dp[idx][tight][used_diff_rot];


        int curr_dig = n.charAt(idx) - '0';
        int ans = 0;       

        for(int i=0; i<arr.length; i++){

            if( tight == 1 && curr_dig < arr[i]) continue;

            int ntight = (tight == 1 && arr[i] == curr_dig) ? 1 : 0;
            
            int n_used_diff_rot = (used_diff_rot == 1 || i > 2) ? 1 : 0;

            ans += digiDP(idx+1, ntight, n_used_diff_rot, n);
        }

        dp[idx][tight][used_diff_rot] = ans;
        return ans;
    }
}