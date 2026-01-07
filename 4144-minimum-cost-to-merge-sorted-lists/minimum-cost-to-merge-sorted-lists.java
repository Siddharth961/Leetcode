class Solution {

    long[] medians;
    long[] size;
    int[][] merged;   // sorted merged arrays per mask

    public long minMergeCost(int[][] lists) {
        int n = lists.length;
        int N = 1 << n;

        medians = new long[N];
        size = new long[N];
        merged = new int[N][];

        merged[0] = new int[0];

        // ---------- FAST PRECOMPUTE ----------
        for (int mask = 1; mask < N; mask++) {
            int lsb = mask & -mask;
            int prev = mask ^ lsb;
            int idx = Integer.numberOfTrailingZeros(lsb);

            merged[mask] = merge(merged[prev], lists[idx]);
            size[mask] = merged[mask].length;
            medians[mask] = merged[mask][(merged[mask].length - 1) / 2];
        }

        // ---------- DP ----------
        long[] dp = new long[N];
        Arrays.fill(dp, Long.MAX_VALUE);

        for (int i = 0; i < n; i++) dp[1 << i] = 0;

        for (int mask = 1; mask < N; mask++) {
            for (int s1 = (mask - 1) & mask; s1 > 0; s1 = (s1 - 1) & mask) {
                int s2 = mask ^ s1;
                if (s1 >= s2) continue;
                if (dp[s1] == Long.MAX_VALUE || dp[s2] == Long.MAX_VALUE) continue;

                long val = dp[s1] + dp[s2]
                         + size[s1] + size[s2]
                         + Math.abs(medians[s1] - medians[s2]);

                dp[mask] = Math.min(dp[mask], val);
            }
        }

        return dp[N - 1];
    }

    // ---------- MERGE TWO SORTED ARRAYS ----------
    private int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            res[k++] = (a[i] <= b[j]) ? a[i++] : b[j++];
        }
        while (i < a.length) res[k++] = a[i++];
        while (j < b.length) res[k++] = b[j++];

        return res;
    }
}
