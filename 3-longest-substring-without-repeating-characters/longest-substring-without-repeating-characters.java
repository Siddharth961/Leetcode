class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> st = new HashSet<>();

        int i=0;
        int j=0;

        int ans = 0;

        while(j<s.length()){

            while( st.contains( s.charAt(j)) ){
                st.remove( s.charAt(i) );
                i++;
            }

            st.add( s.charAt(j) );

            ans = Math.max(ans, j-i + 1);

            j++;
        }

        return ans;
    }
}