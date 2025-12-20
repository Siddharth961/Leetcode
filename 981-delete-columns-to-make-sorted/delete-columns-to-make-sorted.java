class Solution {
    public int minDeletionSize(String[] strs) {
        
        int ans = 0;

        for(int idx=0; idx<strs[0].length(); idx++){

            char prev = 'a';

            for(String s : strs){

                if( prev > s.charAt(idx) ){
                    ans++;
                    break;
                }

                prev = s.charAt(idx);

            }
        }

        return ans;
    }
}