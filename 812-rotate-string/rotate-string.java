class Solution {

    public int[] getLPS(char[] s){

        int[]lps = new int[s.length];

        int len = 0;

        for(int i=1; i<lps.length; i++){

            if( s[len] == s[i]){
                len++;
            }
            else{

                while(len != 0){
                    len = lps[len-1];

                    if( s[len] == s[i]){
                        len++;
                        
                        break;
                    }
                }
            }

            lps[i] = len;
        }

        return lps;
    }
    public boolean rotateString(String s, String goal) {

        if(goal.length() != s.length()) return false;

        
        int i=0;
        int j=0;

        int[]lps = getLPS(goal.toCharArray());

        while( i<2*s.length()){

            if(j == goal.length() ) return true;

            char tar = s.charAt(i % s.length());

            if(tar == goal.charAt(j)){
                i++;
                j++;
            }
            else{
                if(j > 0){
                    j = lps[j-1];
                }
                else i++;
            }
        }

        return false;
    }
}