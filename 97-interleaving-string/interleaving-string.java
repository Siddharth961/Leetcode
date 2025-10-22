class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][]dp = new int[101][101];
        return travel(0, 0, 0, s1, s2, s3, dp);
    }

    public boolean travel(int i, int j, int k, String s1, String s2, String s3, int[][]dp){

        if(i == s1.length() && j==s2.length() && k == s3.length()){
            return true;
        }

        if(k == s3.length()) return false;

        if( dp[i][j] != 0) return dp[i][j] == 1;

        boolean ans = false;

        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
            
            ans = ans || travel(i+1, j, k+1, s1, s2, s3, dp);
        }

        if(j < s2.length() && s2.charAt(j) == s3.charAt(k)){
            
            ans = ans || travel(i, j+1, k+1, s1, s2, s3, dp);
        }

        dp[i][j] = ans == true ? 1 : 2;

        return ans;
    }
}