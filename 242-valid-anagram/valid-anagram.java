class Solution {
    public boolean isAnagram(String s, String t) {
        int[]freq = new int[26];

        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        for(int i=0; i<t.length(); i++){

            char c = t.charAt(i);

            if(freq[c - 'a'] == 0) return false;
            freq[c - 'a']--;
        }

        for(int i=0; i<26; i++) if(freq[i]>0) return false;

        return true;
    }
}