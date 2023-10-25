class Solution {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        int i =  0;

        for(String s : words){
            i=0;
            while(i<s.length() && i<pref.length()){
                if(s.charAt(i) != pref.charAt(i)) break;
                i++;
            }

            if(i==pref.length()) ans++;
        }

        return ans;
    }
}