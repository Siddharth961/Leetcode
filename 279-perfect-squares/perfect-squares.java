class Solution {
    public int numSquares(int n) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=1; i*i<=n; i++) al.add(i*i);

        int[]dp = new int[n+1];

        for(int i=1; i<=n; i++){
            
            for(int j=1; j*j<=i; j++){
                if(j==1) dp[i]=i;
                else dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
            }
                

        }

        return dp[n];

    }
}