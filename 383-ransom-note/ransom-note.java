class Solution {
    public boolean canConstruct(String ran, String mag) {
        HashMap<Character , Integer> mp = new HashMap<>();

        for(char c : ran.toCharArray()) mp.put(c , mp.getOrDefault(c,0)+1);

        for(char c : mag.toCharArray()){
            if(mp.containsKey(c)){
                mp.put(c, mp.get(c)-1);
                if(mp.get(c)==0) mp.remove(c);
            }
            if(mp.size()==0) return true;
        }

        return false;

    }
}