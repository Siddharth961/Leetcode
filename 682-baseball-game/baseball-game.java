class Solution {
    public int calPoints(String[] operations) {
        Stack<String>st = new Stack<>();

        for(int i=0; i<operations.length; i++){
            String s = operations[i];

            if(s.equals("C")){
                st.pop();
            }
            else if(s.equals("D")){
                int val = 2*(Integer.parseInt(st.peek()));
                st.push(""+val);
            }
            else if(s.equals("+")){
                int v1 = Integer.parseInt(st.pop());
                int v2 = Integer.parseInt(st.pop());
                st.push(""+v2);
                st.push(""+v1);
                int v3 = v1+v2;
                st.push(""+v3);
            }
            else st.push(s);
            
        }
        
        int ans = 0;
        for(String a : st){
            ans += Integer.parseInt(a);
        }

        return ans;
    }
}