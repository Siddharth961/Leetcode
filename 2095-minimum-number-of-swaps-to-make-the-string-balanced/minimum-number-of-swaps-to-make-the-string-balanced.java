class Solution {
    public int minSwaps(String s) {
        Stack<Character> st= new Stack<>();
        for(int i=0;i<s.length();i++){

            if(s.charAt(i)=='[')
            st.push(s.charAt(i));

            if(s.charAt(i)==']'&&st.size()!=0&&st.peek()=='[')
            st.pop();
        }
        int res= st.size();
        
        if(res%2==0)
        res=res/2;
        else res=(res+1)/2;
        return res;
    }
}