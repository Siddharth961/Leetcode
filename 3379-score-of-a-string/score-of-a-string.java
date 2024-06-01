class Solution {
    public int scoreOfString(String s) {

        int ans = 0;

        for(int i=1; i<s.length(); i++){
            ans += Math.abs( (int)(s.charAt(i-1) - s.charAt(i)) );

        }

        return ans;
        
    }
}