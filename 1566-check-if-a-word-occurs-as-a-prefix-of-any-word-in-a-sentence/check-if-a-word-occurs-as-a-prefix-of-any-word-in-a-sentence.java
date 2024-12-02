class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int j = 0;
        int word = 1;
        char[]tar = searchWord.toCharArray();
        char[]space = sentence.toCharArray();

        for(int i=0; i<space.length; i++){
            
            while(i<space.length && j<tar.length && space[i] == tar[j]){
                i++;
                j++;
            }

            if(j == tar.length) return word;

            while(i<space.length && space[i] != ' ') i++;
            word++;
            j=0;
        }

        return -1;
        
    }
}