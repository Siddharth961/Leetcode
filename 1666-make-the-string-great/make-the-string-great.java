class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()){
            if(st.size()==0)st.push(c);
            else{
                if( Math.abs(st.peek()-c) != 32) st.push(c);
                else st.pop();
            }            
        }


        StringBuilder sb = new StringBuilder();

        for(var e : st) sb.append(e);
        return sb.toString();
    }
}