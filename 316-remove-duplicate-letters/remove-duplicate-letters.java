class Solution {
    public String removeDuplicateLetters(String s) {
        
        int[]last_index = new int[26];
        for(int i=0; i < s.length(); i++){
            last_index[ s.charAt(i) - 'a'] = i;
        }

        boolean[]picked = new boolean[26];

        Stack<Character>st = new Stack<>();

        for(int i=0; i<s.length(); i++){

            char c = s.charAt(i);

            if( picked[c - 'a'] == true) continue;
             

            while(st.size() > 0 && st.peek() > c && last_index[st.peek() - 'a'] > i){

                picked[ st.pop() - 'a'] = false;
            }

            st.push(c);
            picked[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(var c : st) sb.append(c);

        return sb.toString();
    }
}