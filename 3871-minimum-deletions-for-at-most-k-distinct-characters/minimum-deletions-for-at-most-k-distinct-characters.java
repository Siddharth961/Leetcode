class Solution {
    public int minDeletion(String s, int k) {
        int[]freq = new int[26];

        int distinct = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(freq[c-'a'] == 0) distinct++;

            freq[c - 'a']++;

        }

        if(distinct <= k) return 0;

        Arrays.sort(freq);

        int ans = 0;
        int idx = 0;

        while(distinct > k){

            if(freq[idx] > 0){
                ans += freq[idx];
                distinct--;
            }

            idx++;

        }

        return ans;
    }
}