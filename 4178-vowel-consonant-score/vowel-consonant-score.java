class Solution {
    public int vowelConsonantScore(String s) {
        
        HashSet<Character> st = new HashSet<>();
        st.add('a');
        st.add('e');
        st.add('i');
        st.add('o');
        st.add('u');

        int v = 0;
        int c = 0;
        for(int i=0; i<s.length(); i++){

            char ch = s.charAt(i);

            if(st.contains(ch)) v++;
            else if(ch >= 'a' && ch<='z') c++; 
        }

        if(c == 0) return c;
        return (int)Math.floor(v/c);
    }
}