class Solution {
    public int characterReplacement(String s, int k) {
        
        int ans = 0;

        for(char c = 'A'; c<='Z'; c++){
            ans = Math.max( ans, travel(c, k, s));
        }

        return ans;
    }

    public int travel(char tar, int k, String s){

        int ans = 0;
        int count = 0;

        int j=0;
        int i=0;

        while(j < s.length() ){
            char ch = s.charAt(j);

            if(ch != tar) count++;

            while(count > k){

                if(s.charAt(i) != tar) count--;
                i++;
            }

            ans = Math.max(ans, j-i+1);
            j++;
        }

        return ans;
    }
}