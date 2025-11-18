class Solution {
    public int numDecodings(String s) {
        int[]dp = new int[s.length()];

        for(int i=0; i<s.length(); i++){

            char c = s.charAt(i);

            if(i == 0){

                if(c == '0') return 0;
                dp[0] = 1;
                continue;
            }

            boolean single_digi = parse(' ', c);
            boolean double_digi = parse(s.charAt(i-1), c);

            if(single_digi) dp[i] += dp[i-1];
            if(double_digi ){

                if(i-2 >= 0) dp[i] += dp[i-2];
                else dp[i]++;
            }

            // System.out.println(dp[i] + " " + single_digi + " " + double_digi);

        }

        return dp[ s.length() - 1];
    }

    public boolean parse(char a, char b){

        if( a == '0' || ( a != ' ' && a > '2')) return false;
        if( a == ' ' && b=='0') return false;

        if(a == '2' && b > '6') return false;


        return true;

    }
}