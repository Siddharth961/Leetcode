class Solution {
    public String removeKdigits(String s, int k) {
        
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            while( k>0 && st.size() > 0 && st.peek() > c){
                
                st.pop();
                k--;
                
            }

            st.push(c);
        }

        while(st.size() > 0 && k>0){
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        for(char c : st){
            if(sb.length() > 0 || c != '0') sb.append(c);
        }

        return sb.length() > 0 ? sb.toString() : "0";
    }
}