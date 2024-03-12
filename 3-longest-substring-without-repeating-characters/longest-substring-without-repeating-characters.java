class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int max = 0;
        int start = 0;

        for(int i=0; i<s.length(); i++){
            for(int j=start; j<i; j++){

                if(s.charAt(j) == s.charAt(i)){
                    max = Math.max( max, i-start);
                    start = j+1;
                    break;
                }
            }
        }

        return Math.max( max, s.length()-start);

    }
}