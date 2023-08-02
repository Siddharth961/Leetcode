class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> st = new Stack<>();
        Stack<Character> helper = new Stack<>();
        
        int i=0;;

        while(i<s.length()){
            if(st.size()==0 || st.peek() != s.charAt(i)){
                st.push(s.charAt(i));
                i++;
            }
            else{
                while(i<s.length() && st.peek()==s.charAt(i)){
                    st.push(s.charAt(i));
                    i++;

                }
                int count = k;
                char val = st.peek();

                while(st.size()!=0  && st.peek()==val){
                   
                    helper.push(st.pop());
                    count--;
                if(count==0){
                    helper.clear();
                    count=k;
                }
                }

                if(count!=0){
                    while(helper.size()!=0){
                        st.push(helper.pop());
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : st){
            sb.append(ch);
        }

        return sb.toString();
    }
}