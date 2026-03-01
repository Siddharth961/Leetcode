class Solution {
    public String trimTrailingVowels(String s) {
        HashSet<Character> st = new HashSet<>();

        st.add('a');
        st.add('e');
        st.add('i');
        st.add('o');
        st.add('u');

        for(int i=s.length()-1; i>=0 ; i--){

            if(!st.contains(s.charAt(i))){

                return s.substring(0, i+1);

            }
        }

        return "";
    }
}