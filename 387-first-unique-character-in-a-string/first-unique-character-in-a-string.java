class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(mp.containsKey(c)) mp.put(c, s.length());
            else mp.put(c,i);
        }

        int ans=s.length();

        for(var e : mp.values()){
            if(ans>e)ans=e;
        }

        if(ans<s.length()) return ans;

        return -1;
    }
}