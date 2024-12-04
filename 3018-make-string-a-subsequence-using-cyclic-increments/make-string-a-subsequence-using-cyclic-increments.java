class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        char[]s1 = str1.toCharArray();
        char[]s2 = str2.toCharArray();

        int i=0;
        int j=0;

        while(i<s1.length && j<s2.length){
            if(s1[i] == s2[j]){
                j++;
            }
            else{
                if( s1[i] + 1 == s2[j] || (s1[i]=='z' && s2[j] == 'a') ){
                    j++;
                }
            }

            i++;
        }

        if(j == s2.length) return true;
        return false;
    }
}