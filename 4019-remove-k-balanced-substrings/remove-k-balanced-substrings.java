class Solution {
    public String removeSubstring(String s, int k) {
        Stack<int[]> st = new Stack<>(); // st[0] = 0 -> for '(', st[0] = 1 -> for ')', st[1] -> for count

        for(int i=0; i<s.length(); i++){

            char c = s.charAt(i);

            if( c == '('){

                if( st.size() > 0 && st.peek()[0] == 0){
                    st.peek()[1]++; // increment count
                }
                else st.push( new int[]{0, 1}); // start new '(' line
            }
            else{

                if( st.size() > 0 && st.peek()[0] == 1){
                    st.peek()[1]++; // increment count
                }
                else st.push( new int[]{1, 1}); // start new '(' line

                // removal process

                while(st.size() > 1 && st.peek()[0] == 1 && st.peek()[1] >= k ){
                    int[]b = st.pop(); // top array of ')'
                    int[]a = st.pop(); // top array of '('

                    int val = Math.min(b[1], a[1]);

                    if( val < k){
                        st.push(a);
                        st.push(b);

                        break;
                        
                    }

                    a[1] -= k;
                    b[1] -= k;
                    
                    // entire '(' array will be removed hence remaining ')' willcombine with previous array
                    if(a[1] == 0){ 

                        if(st.size() > 0){
                            st.peek()[1] += b[1] ;
                        }
                        else if(b[1] > 0) st.push(b);

                    }
                    else{
                        st.push(a);
                        if(b[1] > 0) st.push(b);
                    }
                
                }

            }

        // for(var a : st){
        //     if(a[0] == 0) System.out.print("( ");
        //     else System.out.print(") ");

        //     System.out.print(a[1] + " , ");
        // }

        // System.out.println("end");
        }

        StringBuilder sb = new StringBuilder();

        for(int[]a : st){

            while(a[1] > 0){

                if(a[0] == 0) sb.append('(');
                else sb.append(')');

                a[1]--;
            }
        }


        return sb.toString();
    }
}