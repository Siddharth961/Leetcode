class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character , Integer> mp = new HashMap<>();

        for(char c : s.toCharArray()){
            if(mp.containsKey(c)) mp.put( c , mp.get(c)+1);
            else mp.put(c,1);
        }

        for(char c : t.toCharArray()){
            if(mp.containsKey(c)) mp.put( c , mp.get(c)-1);
            else mp.put(c,-1);
        }
        
        int count = 0;

        for(var e : mp.values()){
            count += Math.abs(e);
        }

        return count;
    }
}