class Solution {
    int[]dp;
    public int minCut(String s) {

        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        
        return travel(0, s);
    }

    public int travel(int idx, String s){

        if(dp[idx] != -1) return dp[idx];

        int ans = Integer.MAX_VALUE;

        for(int end = idx; end < s.length(); end++){

            String part = s.substring(idx, end+1);

            if(isPalindrome(part)){

                if(end == s.length() - 1){
                    // entire [idx .. s.length] is palindrome .. so no cuts
                    ans = 0;
                    break;
                }

                int val = 1 + travel(end+1, s);
                ans = Math.min(ans, val);
            }
        }

        dp[idx] = ans;

        return ans;
    }

    public boolean isPalindrome(String s){
        int i = 0;
        int j = s.length()-1;

        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;

            i++;
            j--;
        }

        return true;
    }
}