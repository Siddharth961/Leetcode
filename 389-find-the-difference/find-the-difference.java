class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> mp = new HashMap<>();

        for(char c : s.toCharArray()){
            if(mp.containsKey(c)) mp.put(c , mp.get(c)+1);
            else mp.put(c,1);
        }
        for(char c : t.toCharArray()){
            if(mp.containsKey(c)==false || mp.get(c)==0) return c;
            else mp.put(c, mp.get(c)-1);
        }

        return ' ';
    }
}