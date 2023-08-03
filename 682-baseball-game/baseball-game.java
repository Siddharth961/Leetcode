class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer>st = new Stack<>();

        for(int i=0; i<operations.length; i++){
            String s = operations[i];

            if(s.equals("C")){
                st.pop();
            }
            else if(s.equals("D")){
                st.push(2*st.peek());
            }
            else if(s.equals("+")){
                int v1 = st.pop();
                int v2 = st.pop();
                st.push(v2);
                st.push(v1);
                
                st.push(v1+v2);
            }
            else st.push(Integer.parseInt(s));
            
        }
        
        int ans = 0;
        while(st.size()!=0) ans += st.pop();

        return ans;
    }
}