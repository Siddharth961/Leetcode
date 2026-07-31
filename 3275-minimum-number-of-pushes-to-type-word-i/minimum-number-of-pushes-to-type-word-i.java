class Solution {
    public int minimumPushes(String word) {
        
        int segs_of_8 = word.length() / 8;
        int remaining = word.length() % 8;

        // for seg of 8
        // 1 * ( 1st seg) + 2 * ( 2nd seg ) ...
        // ( 1 + 2 + ..) * (seg size)
        // (1 + 2 = ..) * 8

        // for remaining
        // remaining * (segs_of_8  + 1 )

        int ans = (( ( segs_of_8 * (segs_of_8 + 1) ) / 2) * 8 ) + remaining * (segs_of_8 + 1);

        return ans;
    }
}