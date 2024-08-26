class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[]arr1 = text1.toCharArray();
        char[]arr2 = text2.toCharArray();

        int[][]dp = new int[arr2.length][arr1.length];
        int val = 0;

        for(int i = 0; i<arr2.length; i++){
            for(int j=0; j<arr1.length; j++){
                val = 0;
                if(arr2[i] == arr1[j]){
                    if(i>0 && j>0) dp[i][j] = dp[i-1][j-1];
                    dp[i][j] += 1;
                }
                else{
                    if(i>0) val = Math.max(val, dp[i-1][j]);
                    if(j>0) val = Math.max(val, dp[i][j-1]);
                    dp[i][j] = val;
                }
            }
        }

        return dp[arr2.length - 1][arr1.length - 1];
    }
}