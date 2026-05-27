class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        
        if(s.charAt(s.length()-1) != '0') return false;
        boolean[]dp = new boolean[s.length()];


        dp[s.length()-1] = true;
        int closest_true = s.length()-1;

        for(int i=s.length()-2; i >= 0; i--){

            

            if(i + minJump < s.length() && dp[i+minJump] == true){

                
                closest_true = i+minJump;

                // continue;

            }

            if(s.charAt(i) == '0' &&  i+minJump <= closest_true && closest_true <= i + maxJump){
                dp[i] = true;
            }

            // System.out.println(i + " " + dp[i] + " closest " + closest_true);

        }

        return dp[0];
    }
}