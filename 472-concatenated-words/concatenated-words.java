class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> options = new HashSet<>();

        for(String s : words) options.add(s);

        List<String>ans = new LinkedList<>();

        for(String s : words){

            options.remove(s);

            int[]dp = new int[s.length() + 1];

            boolean val = check(0, 0, 0, options, s, dp);
            if(val) ans.add(s);
            options.add(s);
        }

        return ans;
    }

    public boolean check( int st, int en, int splits, HashSet<String>options, String s, int[]dp){

        if(en == s.length()){
            if(st == en) return true;

            return false;
        }

        if(dp[st] != 0) return dp[st] == 2;

        

        String str = s.substring(st, en+1);

        boolean ans = false;

        if( options.contains(str) ){

            ans = check( en+1, en+1, splits+1, options, s, dp ); // splitting curr string - checking remaining
        }

        ans = ans || check(st, en+1, splits, options, s, dp); // checking curr string without splitting

        if(ans) dp[st] = 2;
        else dp[st] = 1;

        return ans;

    }
}