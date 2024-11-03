class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[]dict = new int[26];
        char[]ord = order.toCharArray();

        for(int i=0; i<ord.length; i++){
            dict[ ord[i]-'a' ] = i;
        }

        for(int i=1; i<words.length; i++){

            int len = Math.max(words[i-1].length() , words[i].length() );
            int j = 0;
            
            while( j<len ){
                char a = j<words[i-1].length() ? words[i-1].charAt(j) : ' ';
                char b = j<words[i].length() ? words[i].charAt(j) : ' ';

                if(a != ' ' && b == ' ') return false;
                if(a == ' ') break;

                if( dict[ a - 'a'] > dict[b - 'a' ]) return false;
                else if( dict[a - 'a' ] < dict[b-'a' ]) break;

                j++;
            }
        }

        

        return true;
        
    }
}