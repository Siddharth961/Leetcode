class Solution {
    public int passThePillow(int n, int time) {
        int completed = time/(n-1);
        int remain = time%(n-1);

        int ans = completed % 2 == 0 ? remain + 1 : n - remain;

        return ans;
    }
}