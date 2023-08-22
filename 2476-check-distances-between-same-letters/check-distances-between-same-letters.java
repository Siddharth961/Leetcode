class Solution {
    public boolean checkDistances(String s, int[] distance) {
        HashMap<Character, Integer> mp = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(mp.containsKey(c)==false) mp.put(c,i);
            else mp.put(c, i-mp.get(c)-1);
        }

        

        for(var e : mp.entrySet()){
            int idx = (int)(e.getKey() - 'a');
            if(distance[idx]!=e.getValue()) return false;
        }

        return true;
    }
}