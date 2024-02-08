class Solution {
    public int numSquares(int n) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=1; i*i<=n; i++) al.add(i*i);

        int[][]dp = new int[al.size()][n+1];

        for(int i=0; i<al.size(); i++){
            
            for(int j=1; j<=n; j++){
                if(i==0){
                    dp[i][j] = j;
                    continue;
                }
                if(j<al.get(i)) dp[i][j] = dp[i-1][j];
                else{
                 dp[i][j] = Math.min(dp[i][j - al.get(i)] + 1, dp[i-1][j]);
                }    
            }
                

        }

        return dp[al.size()-1][n];
    }
}