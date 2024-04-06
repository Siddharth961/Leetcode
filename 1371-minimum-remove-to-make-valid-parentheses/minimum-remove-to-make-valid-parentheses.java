class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int open = 0;

        for(char c : s.toCharArray()){
            if(c=='(') open++;
            else if(c==')'){
                if(open==0) continue;
                else open--;
            }

            st.push(c);
        }

        System.out.println(st);

        StringBuilder sb  =new StringBuilder();

        int close = 0;

        while(st.size()>0){

            char c = st.pop();

            if(c==')') close++;
            else if(c=='('){
                if(close==0) continue;
                else close--;
            }

            sb.append(c);

        }
        return sb.reverse().toString();
    }
}