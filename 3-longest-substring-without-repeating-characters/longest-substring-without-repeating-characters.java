class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character, Integer> mp = new HashMap<>();
        int i = 0;
        int len = 0;
        int ans = 0;

        while(i < s.length()){
            char c = s.charAt(i);

            if( mp.containsKey(c) == false ){
                mp.put(c, i);
                len++;
            }
            else{
                i = mp.get(c);
                mp.clear();
                if(ans < len) ans = len;
                len = 0;               
                
            }

            i++;
        }

        if(ans < len) return len;
        return ans;
    }
}