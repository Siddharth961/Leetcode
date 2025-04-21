class Solution {
    public int numRabbits(int[] answers) {
        

        int[]freq = new int[1001];

        for(int i : answers) freq[i]++;

        int ans = 0;

        for(int i=0; i<1001; i++){

            if(freq[i]>0){
                ans += freq[i];
                if(freq[i]%(i+1) != 0) ans += (i+1) - (freq[i] % (i+1) );
            }
        }

        return ans;
    }

}