class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();

        int ans = 0;

        for(char c : s.toCharArray()){
            if(!mp.containsKey(c)) mp.put(c,1);
            else{
                mp.put(c , mp.get(c)+1);
                if(mp.get(c)==2){
                    ans += 2;
                    mp.remove(c);
                }
            }
        }

        if(mp.size()>0) ans += 1;

        return ans;
    }
}