class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int small_i = m;
        int small_j = n;

        for(int[]arr : ops){
            small_i = Math.min( small_i, arr[0]);
            small_j = Math.min( small_j, arr[1]);
        }

        return small_i * small_j;
    }
}