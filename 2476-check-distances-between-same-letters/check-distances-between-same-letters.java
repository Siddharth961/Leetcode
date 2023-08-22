class Solution {
    public boolean checkDistances(String s, int[] distance) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int idx=0,d=0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(mp.containsKey(c)==false) mp.put(c,i);
            else{
                idx = (int)(c - 'a');
                d = i - mp.get(c) - 1;
                if(distance[idx]!=d) return false;
            }
        }



        return true;
    }
}