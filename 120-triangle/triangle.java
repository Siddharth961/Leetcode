class Solution {
    public int minimumTotal(List<List<Integer>> tri) {
        int r = tri.size();
        int c = tri.get(r-1).size();

        int[][]dp = new int[r][c];
        for(int[]arr : dp)Arrays.fill(arr, Integer.MAX_VALUE);

        return get_ans(tri, 0, 0, dp);
    }

    public int get_ans(List<List<Integer>> tri, int r, int c, int[][]dp){
        

        if(r==tri.size()) return 0;
        if(dp[r][c] != Integer.MAX_VALUE) return dp[r][c];

        List<Integer> al = tri.get(r);
                

        int x = get_ans(tri, r+1, c, dp);
        int y = get_ans(tri, r+1, c+1, dp);

        int ans  = al.get(c) + Math.min(x , y);    
         
        dp[r][c] = ans;
        return ans; 
    }
}