class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mp = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char a1 = s.charAt(i);
            char a2 = t.charAt(i);

            if(mp.containsKey(a1)==true){
                if(mp.get(a1) != a2) return false;

            }
            else if(mp.containsValue(a2)==true) return false;
            else{
                mp.put(a1,a2);
            }

        }

        return true;
    }
}