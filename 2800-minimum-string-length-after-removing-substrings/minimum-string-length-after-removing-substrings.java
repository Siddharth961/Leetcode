class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(st.size()!=0){ 

                if(c == 'B' && st.peek() == 'A'){
                    st.pop();
                    continue;
                }

                else if(c == 'D' && st.peek() == 'C'){
                    st.pop();
                    continue;
                }
            }
            st.push(c);
        }

        return st.size();
    }
}