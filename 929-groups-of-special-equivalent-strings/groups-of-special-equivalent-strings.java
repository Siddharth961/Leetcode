class Solution {
    public int numSpecialEquivGroups(String[] words) {
        if(words.length==1) return 1;
        HashSet<String> st = new HashSet<>();

        for(String s : words){
            st.add(mark(s));
        }

        return st.size();
    }

    public String mark(String s){
        byte[][] arr = new byte[2][26];

        for(int i=0; i<s.length(); i++){
            if(i%2==0) arr[0][s.charAt(i)-'a']++;
            else arr[1][s.charAt(i)-'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<26; i++){
            sb.append(arr[0][i]);
            sb.append(arr[1][i]);
        }

        return sb.toString();
    }
}