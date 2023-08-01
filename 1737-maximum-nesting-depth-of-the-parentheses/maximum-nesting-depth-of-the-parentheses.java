class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int max = 0;
        int count=0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(c=='('){
                count++;
                st.push(c);
            }
            else if(c==')'){
                count--;
                st.pop();
            }
            if(max<count)max = count;
            
        }
        return max;
    }
}