class Solution {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;

        for(String s : words){
            if(s.length()<pref.length()) continue;
           
            if(s.substring(0, pref.length()).equals(pref)) ans++;
        }

        return ans;
    }
}