class Solution {
    public int hIndex(int[] citations) {

        int[]freq = new int[1001];

        for(int i : citations) freq[i]++;

        int ans = 0;
        int count = 0;

        for(int i=1000; i>=0; i--){

            if( i >= count){
                ans = Math.min(count + freq[i], i );
                // System.out.println(ans);
                count += freq[i];
            }
            else return ans;
        }

        return ans;


    }
}