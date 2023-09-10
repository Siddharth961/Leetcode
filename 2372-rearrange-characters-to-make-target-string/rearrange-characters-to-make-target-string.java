class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[]sarr = new int[26];
        int[]tarr = new int[26];

        for(int i=0; i<s.length(); i++){
            sarr[s.charAt(i)-'a']++;
            
        }
        for(int i=0; i<target.length(); i++){
            tarr[target.charAt(i)-'a']++;
            
        }

        
        int ans = Integer.MAX_VALUE;
        int val=0;
            

        
        for(int i=0; i<target.length(); i++){
            char c = target.charAt(i);
            if(tarr[c-'a']>0 && sarr[c-'a']==0) return 0;
            if(tarr[c-'a']==0) continue;

            val = sarr[c-'a']/tarr[c-'a'];

            if(ans>val) ans = val;
        }

        return ans;

    }
}