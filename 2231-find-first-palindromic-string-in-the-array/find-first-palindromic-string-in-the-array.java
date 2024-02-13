class Solution {
    public String firstPalindrome(String[] words) {
        for(String s : words){
            int i=0;
            int j = s.length()-1;
            while(i<=j){
                if(s.charAt(i) != s.charAt(j)) break;
                i++;
                j--;
            }
            if(i>j) return s;
        }
        return "";
    }
}