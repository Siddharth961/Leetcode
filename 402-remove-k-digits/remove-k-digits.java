class Solution {
    public String removeKdigits(String num, int k) {
        
        Stack<Character> st = new Stack<>();

        for(char a : num.toCharArray()){

            while(st.size()>0 && st.peek()>a && k>0){
                st.pop();
                k--;
            }

            st.push(a);
        }

        while(k>0 && st.size()>0){
            st.pop();
            k--;
        }

        // System.out.print(st);

        if(k>0) return "0";

        boolean nonzero = false;

        StringBuilder sb = new StringBuilder();

        for(var e : st){
            if(e != '0') nonzero = true;
            if(nonzero==true) sb.append(e);
        }

        return sb.length()>0 ? sb.toString() : "0";

    }
}