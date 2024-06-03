class Solution {
    public int appendCharacters(String s, String t) {
        int i=0;
        int j=0;
        char[] word = s.toCharArray();
        char[]tar = t.toCharArray();

        while(i<word.length && j<tar.length){
            if(word[i]==tar[j]) j++;

            i++;
        }

        return tar.length - j;
    }
}