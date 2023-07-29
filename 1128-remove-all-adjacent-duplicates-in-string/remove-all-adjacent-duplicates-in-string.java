class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(st.size()==0) st.push(c);
            else if(st.peek()==c) st.pop();
            else st.push(c);
        }
        String ans = "";
        for(char ch : st){
            ans += ch;
        }
        return ans;
    }
}