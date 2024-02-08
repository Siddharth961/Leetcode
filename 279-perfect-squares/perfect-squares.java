class Solution {
    public int numSquares(int n) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=1; i*i<=n; i++) al.add(i*i);

        int[]dp = new int[n+1];

        for(int i=0; i<al.size(); i++){
            
            for(int j=1; j<=n; j++){
                if(i==0) dp[j] = j;
                else if(j>=al.get(i))dp[j] = Math.min(dp[j], dp[j-al.get(i)] + 1) ;
                
            }
                

        }

        return dp[n];

    }
}