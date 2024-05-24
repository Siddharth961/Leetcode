class Solution {
    int ans = 0;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        
        int[]freq = new int[26];

        for(int i=0; i<letters.length; i++){

            freq[ letters[i]-'a' ]++;
        }
        

        get_ans(0, 0, words, freq, score);
        return ans;

    }

    public void get_ans(int idx, int asf, String[]words, int[]freq, int[]score){

        if(idx==words.length){
            if(ans<asf) ans = asf;
            return;
        }

        int[]temp = new int[26];
        char[]word = words[idx].toCharArray();

        int val=0;
        boolean valid = true;
        int temp_idx = 0;

        for(int i=0; i<word.length; i++){

            temp_idx = word[i]-'a';

            if(freq[temp_idx]==0){
                valid=false;
                break;
            }

            temp[ temp_idx ]++;
            freq[temp_idx]--;
            val += score[temp_idx];
        }



        if(valid==true){
            get_ans(idx+1, asf+val, words, freq, score);
        }
        

        for(int i=0; i<26; i++){
            
            freq[i] += temp[i];
        }

        
        get_ans(idx+1, asf, words, freq, score);
    }
}