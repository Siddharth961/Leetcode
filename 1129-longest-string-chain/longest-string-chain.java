class Solution {
    int[][]dp;
    public int longestStrChain(String[] words) {
        
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        dp = new int[words.length][words.length];
        for(int[]a : dp) Arrays.fill(a , -1);

        return get_ans(-1, 0, words);
    }

    public int get_ans(int prev, int curr, String[]words){

        if(curr == words.length ) return 0;

        if(prev != -1 && dp[prev][curr] != -1) return dp[prev][curr];

        // take

        int ans = 0;

        if(prev == -1 ||  check(words[prev], words[curr] ) ){

            ans = 1 + get_ans(curr, curr+1, words);

        }

        // no take

        ans = Math.max(ans, get_ans(prev, curr+1, words) );

        if(prev != -1 ) dp[prev][curr] = ans;

        return ans;

    }

    public boolean check (String s1, String s2){

        if( s1.length() + 1 != s2.length() ) return false;

        int i=0;
        int j=0;

        while( i < s1.length() && j<s2.length() ){

            if(s1.charAt(i) == s2.charAt(j)){
                i++;
            }
            
            j++;
            
        }

        return i == s1.length();

        
    }
}