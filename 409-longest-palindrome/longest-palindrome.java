class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> st = new HashSet<>();

        int ans = 0;

        for(char c : s.toCharArray()){
            if(!st.contains(c)) st.add(c);
            else{                
                ans += 2;
                st.remove(c);                
            }
        }

        if(st.size()>0) ans += 1;

        return ans;
    }
}