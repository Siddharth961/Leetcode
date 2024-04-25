class Solution {
    public int longestIdealString(String s, int k) {
        

       

        char[]arr = s.toCharArray();

        int[]dp = new int[27];


        for(int i=0; i<arr.length; i++){
            int idx = arr[i] - 'a';
            int max = -1;
            int left = Math.max((idx-k), 0);
            int right = Math.min((idx + k), 26);
            
            for(int j = left; j <= right ; j++){
                max = Math.max(max, dp[j]);
            }
            dp[idx] = max+1;
        }

        int ans = 0;

        for(int i : dp) ans = Math.max(ans, i);
        
        return ans;
    }
}