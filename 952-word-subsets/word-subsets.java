class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[]freq_b = get_freq_b(words2);

        List<String> ans = new ArrayList<>();

        int[]freq_a = new int[26];

        for(String s : words1){

            Arrays.fill(freq_a, 0);

            for(char c : s.toCharArray()){
                freq_a[c-'a']++;
            }

            int i = 0;

            for(; i<26; i++){

                if(freq_a[i] < freq_b[i]) break;

            }

            if(i==26) ans.add(s);
        }

        return ans;

    }

    public int[] get_freq_b(String[]words){

        int[]max_freq = new int[26];
        int[]freq = new int[26];

        for(String s : words){
            Arrays.fill(freq, 0);

            for( char c : s.toCharArray()){

                freq[c - 'a']++;
                max_freq[c-'a'] = Math.max( max_freq[c-'a'], freq[c-'a']);
            }
        }

        return max_freq;
    }
}