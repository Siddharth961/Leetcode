class Solution {
    public String decodeString(String s) {
        
        Stack<String> st = new Stack<>();

        for(int i=0; i<s.length(); i++){

            char c = s.charAt(i);

            // if( c == '[') continue;

            if(c >= '0' && c <='9'){

                if( isSame(st, c) ){
                    st.push( st.pop() + c );
                }
                else st.push(c+"");
            }

            else if( c != ']'){
                st.push(c+"");
            }

            else {

                StringBuilder sb = new StringBuilder();
                String str = "";

                while(st.peek().equals("[") == false){
                    str = st.pop() + str;
                }

                st.pop(); // remove open bracket

                // String str = sb.reverse().toString(); 
                String num = st.pop();

                String eval = parse(num, str);
                st.push(eval);
            }

            // System.out.println(st);
        }

        StringBuilder sb = new StringBuilder();

        for(String str: st) sb.append(str);

        return sb.toString();
    }

    public boolean isSame(Stack<String> st, char c ){

        if( st.size() == 0) return false;

        char c1 = st.peek().charAt(0);

        if( (c >= '0' && c <='9') && (c1 >= '0' && c1 <='9') ) return true;

        // if( (c >= 'a' && c <='z') && (c1 >= 'a' && c1 <='z') ) return true;

        return false;
    }

    public String parse(String num, String s){

        int n = Integer.parseInt(num);

        StringBuilder sb = new StringBuilder();

        while(n > 0){
            sb.append(s);
            n--;
        }

        return sb.toString();
    }
}