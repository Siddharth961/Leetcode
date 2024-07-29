class Solution {
    public int minOperations(int n) {
        int target = n; // ( (2*n)-1  +  1)/2
        int a = target-1;
        int d = -2;
        int size = n/2;

        int ans = ((size)*( 2*a + (size-1)*d ))/2;

        return ans;
    }
}