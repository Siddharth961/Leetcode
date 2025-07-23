class Solution {
    public int maximumGain(String s, int x, int y) {
        int amt = x > y ? x : y;
        String tar = x > y ? "ab" : "ba";

        int total = 0;

        Deque<Character> dq = new LinkedList<>();

        for(int i=0; i<s.length(); i++){
            dq.offer( s.charAt(i));
        }

        total += traverse(dq, tar, amt);

        // System.out.println(total+" " + dq);
         amt = x <= y ? x : y;
         tar = x <= y ? "ab" : "ba";

        total += traverse(dq, tar, amt);

        return total;

        
        
    }

    public int traverse( Deque<Character> dq, String tar, int amt){

        Stack<Character> st = new Stack<>();

        int total = 0;

        while(dq.size() > 0){
            char c = dq.poll();

            if(st.size()>0 &&  c == tar.charAt(1) && st.peek() == tar.charAt(0)){
                st.pop();
                total += amt;
            }
            else st.push(c);
        }

        for( char c: st){
            dq.offerLast( c );
        }

        return total;
    }

}

