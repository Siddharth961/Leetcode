class Solution {
    public String removeOccurrences(String s, String part) {
        
        Stack<Character> st = new Stack<>();
        Stack<Character> helper = new Stack<>();        

        char end_char = part.charAt( part.length() - 1);

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if( c == end_char ){

                int j = part.length() - 2;

                while(j>=0 && st.size()>0 && st.peek() == part.charAt(j)){
                    helper.push( st.pop() );
                    j--;
                }

                if(j < 0){
                    helper.clear();
                }

                else{
                    while(helper.size() > 0){
                        st.push( helper.pop() );
                    }

                    st.push(c);
                }

            }

            else st.push(c);

        }
        StringBuilder sb = new StringBuilder();

        st.stream().forEach( c -> sb.append(c));
        return sb.toString();
    }
}