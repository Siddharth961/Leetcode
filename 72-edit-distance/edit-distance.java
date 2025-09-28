class Solution {
    int[][]dp ;
    public int minDistance(String word1, String word2) {

        dp = new int[word1.length()][word2.length()];
        for(int[] row : dp) Arrays.fill(row, -1);
        return get_ans( 0, 0, word1, word2);
    }

    public int get_ans(int i, int j,  String word1, String word2){

        if(j == word2.length() ){
            int ops = word1.length() - i ;

            return ops;

        }

        if(i == word1.length() ){
            int ops = word2.length() - j;
            return ops;
        }

        if(dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MAX_VALUE;

        // insert before this index
        int val = get_ans(i, j+1, word1, word2);

        ans = Math.min(ans, val+1);

        // delete / skip this elment

        val = get_ans(i+1, j,  word1, word2 );
        ans = Math.min(ans, val+1);

        // if same elment
        if(word1.charAt(i) == word2.charAt(j)){

            val = get_ans(i+1, j+1, word1, word2);
            ans = Math.min(ans, val); // no operation needed
        }

        else{
            // replace
            val = get_ans(i+1, j+1, word1, word2);
            ans = Math.min(ans, val+1); //  operation needed
            
        }

        if(ans == Integer.MAX_VALUE) ans--;

        dp[i][j] = ans;

        return ans;


        
    }
}