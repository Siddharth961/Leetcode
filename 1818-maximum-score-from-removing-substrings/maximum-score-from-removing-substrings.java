class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> st = new Stack<>();
        Stack<Character> lower = new Stack<>();
        int ans = 0;

        for(char c : s.toCharArray()){

            if( y > x){

                if(c == 'a' ){

                    if(st.size()>0 && st.peek()=='b'){

                        st.pop();
                        ans += y;
                        // System.out.println(ans+"--");
                    }
                    else st.push(c);
                }

                else if( c == 'b') st.push(c);

                else{
                    lower.clear();
                    // System.out.println(ans+"--"+st);
                    while(st.size()>0){
                        char top = st.pop();
                        if(top=='b') lower.push(top);
                        else if(top=='a'){
                            if(lower.size()>0 && lower.peek()=='b'){
                                ans += x;
                                lower.pop();
                            }
                            else lower.push(top);
                        } 
                    }
                }
            }

            else{
                if(c == 'b' ){

                    if(st.size()>0 && st.peek()=='a'){

                        st.pop();
                        ans += x;
                    }
                    else st.push(c);
                }

                else if( c == 'a') st.push(c);

                else{
                    lower.clear();
                    // System.out.println(ans+"--"+st);
                    while(st.size()>0){
                        char top = st.pop();
                        if(top=='a') lower.push(top);
                        else if(top=='b'){
                            if(lower.size()>0 && lower.peek()=='a'){
                                ans += y;
                                lower.pop();
                            }
                            else lower.push(top);
                        } 
                    }
                }
            }

        }

        if(y>x){
            lower.clear();
                    // System.out.println(ans+"--"+st);
                    while(st.size()>0){
                        char top = st.pop();
                        if(top=='b') lower.push(top);
                        else if(top=='a'){
                            if(lower.size()>0 && lower.peek()=='b'){
                                ans += x;
                                lower.pop();
                            }
                            else lower.push(top);
                        } 
                    }
        }
        else{
            lower.clear();
                    // System.out.println(ans+"--"+st);
                    while(st.size()>0){
                        char top = st.pop();
                        if(top=='a') lower.push(top);
                        else if(top=='b'){
                            if(lower.size()>0 && lower.peek()=='a'){
                                ans += y;
                                lower.pop();
                            }
                            else lower.push(top);
                        } 
                    }
        }

        return ans;
    }
}