class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int i : asteroids){

            if( i < 0){
                
                while( st.size() > 0 && st.peek() > 0 &&  st.peek() < - i){
                    st.pop();
                }

                if( st.size() == 0 || st.peek() < 0 ) st.push(i);
                else if( st.peek() == -i ) st.pop();
            }
            else{

                st.push(i);

            }
        }

        int[]ans = new int[st.size()];

        int idx = 0;
        for(int val : st){
            ans[idx] = val;
            idx++;
        }

        return ans;
    }
}