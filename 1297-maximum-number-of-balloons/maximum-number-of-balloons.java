class Solution {
    public int maxNumberOfBalloons(String text) {
        int count_b = 0;
        int count_a = 0;
        int count_l = 0;
        int count_o = 0;
        int count_n = 0;

        for(int i=0; i<text.length(); i++){
            char c = text.charAt(i);

            if( c == 'b') count_b++;
            if( c == 'a') count_a++;
            if( c == 'l') count_l++;
            if( c == 'o') count_o++;
            if( c == 'n') count_n++;
        }

        int ans = count_b;

        ans = Math.min(ans, count_a);
        ans = Math.min(ans, count_l/2);
        ans = Math.min(ans, count_o/2);
        ans = Math.min(ans, count_n);

        return ans;
    }
}