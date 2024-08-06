class Solution {
    public int minimumPushes(String word) {
        
        int[]freq = new int[26];
        for(char c : word.toCharArray()){
            freq[c-'a']++;
        }

        Arrays.sort(freq);

        int count = 0;
        int multi = 1;
        int ans = 0;

        for(int i=25; i>=0; i--){

            if(freq[i]>0){
                count++;
                if(count==9){
                    multi++;
                    count=1;
                }

                ans += freq[i]*multi;
            }
        }

        return ans;
    }
}