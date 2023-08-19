class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i=0; i<jewels.length(); i++){
            char c = jewels.charAt(i);
            mp.put(c,0);
        }
        for(int i=0; i<stones.length(); i++){
            char c = stones.charAt(i);
            if(mp.containsKey(c)==true){
                mp.put(c, mp.get(c)+1);
            }
        }
        int ans=0;
        for(int a : mp.values()){
            ans += a;
        }
        return ans;
    }
}