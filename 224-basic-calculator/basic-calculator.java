class Solution {
    public int calculate(String s) {
        Stack<String> st = new Stack<>();

        for(int i=0; i<s.length(); i++){

            char c = s.charAt(i);
            if(c == ' ') continue;

            // System.out.println(st);


            if(c == '+' || c == '-'){
                if(st.size() == 0 || st.peek().equals("(") ) st.push("0");

                st.push( c + "");
                continue;

            }
            if( c == '('){
                st.push( c + "");
                continue;
            }


            if( c >= '0' && c <= '9'){

                String num2 = "";

                int j=i;
                while( j<s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') j++;

                num2 = s.substring(i, j);
                i=j-1;

                if( st.size() > 0 && (st.peek().equals("+") || st.peek().equals("-"))){
                    String op = st.pop();
                    String a = st.pop();
                    

                    String evaluated = eval(a, op, num2);

                    st.push(evaluated);
                }

                

                else st.push(num2);
                
            }

            if(c == ')' ){
                String str = st.pop();

                st.pop();
                if(st.size() > 0 && (st.peek().equals("+") || st.peek().equals("-"))){
                    String op = st.pop();
                    String a = st.pop();

                    str = eval(a, op, str);
                }


                st.push(str);

            }
        }

            // System.out.println(st);


        int ans = convert( st.pop() );

        return st.size() > 0 ? - ans : ans;
    }

    public String eval(String a, String op, String b){


        int num1 = convert(a);
        int num2 = convert(b);

        // System.out.println(num1 + " " + num2);
        if(op.equals("+")) return num1 + num2 + "";

        return num1 - num2 + "";
    }

    public int convert(String s){
        int val = 0;

        int i=0;
        boolean negative = false;

        if(s.charAt(i) == '-' ){
            negative = true;
            i++;
        }

        for(; i<s.length(); i++){
            int n = (int)(s.charAt(i) - '0');

            val = val*10 + n;
            // System.out.println(val);
        }

        return negative == false ?  val : -val;
    }

}

// push elments as string 
// if number and peek is + - then eval and push result
// if + - push them
// if ( , push it
// if ) , then only single number is between ) , ( .. pop number and (  and push number

// at last if stack size greater then 1 it means answer is negative