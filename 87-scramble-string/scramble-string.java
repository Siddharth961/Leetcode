class Solution {
    HashMap<String, Boolean> mp = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        
        if(s1.equals(s2) ) return true;

        if( s1.length() == 1) return false;

        String key = s1 + " " + s2;

        if(mp.containsKey( key )) return mp.get(key);

        int n = s1.length();

        boolean ans = false;

        for(int i=1; i<n; i++){

            // no swap
            ans = ans || ( isScramble( s1.substring(0, i), s2.substring(0, i) )
                            &&  isScramble( s1.substring(i, n), s2.substring(i, n) ));

            // swap

            ans = ans || ( isScramble( s1.substring(0, i), s2.substring(n-i, n) )
                            &&  isScramble( s1.substring(i, n), s2.substring(0, n-i) ));

            
            if(ans == true) break;

            
        }

        mp.put( key, ans);

        return ans;
    }
}