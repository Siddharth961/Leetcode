class Solution {
    public int countLargestGroup(int n) {
        // return n%9 == 0 ? 9 : n%9;

        int[]freq = new int[37];

        int max = 0;
        int count = 0;

        for(int i=1; i<=n; i++){
            int val = count(i);

            freq[val]++;

            if( max < freq[val]){
                max = freq[val];
                count = 1;
            }
            else if( max == freq[val]){
                count++;
            }
        }

        return count;
    }

    public int count( int n ){
        int ans = 0;

        while(n>0){
            ans += n%10;
            n = n/10;
        }

        return ans;
    }
}
// 1  2  3  4  5  6  7  8  9 
// 10 11 12 13 14 15 16 17 18
// 19 20 21 22 23 24 25 26 27
// 28 29 30