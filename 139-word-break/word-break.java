class Solution {
    HashMap<String, Boolean> mp = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        
        HashSet<String>st = new HashSet<>();


        for(String str : wordDict) st.add(str);

        return get_ans(0, s, "", st);
        
    }

    public boolean get_ans(int idx, String s, String ssf, HashSet<String>st ){
        if(idx == s.length()){

            return ssf.length() == 0;

        }

        ssf = ssf + s.charAt(idx);

        String key = ssf + " " + idx;

        if(mp.containsKey(key)) return mp.get(key);

        boolean ans = false;

        if( st.contains(ssf) ){
            ans = ans || get_ans(idx + 1, s, "" , st);
        }

        ans = ans || get_ans(idx+1, s, ssf, st);

        mp.put( key, ans);

        return ans;
    }
}