class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare( arr[a[0]] * arr[b[1]], arr[a[1]]*arr[b[0]] )

        );

        for(int i=0; i<arr.length-1; i++){
            pq.add( new int[] { i, arr.length-1 });
        }

        for(int i=1 ; i<k; i++){

            int[] frac = pq.poll();

            int num = frac[0];
            int den = frac[1];

            if(den-1 > num) pq.add( new int[]{num, den-1});
        }

        int[]ans = pq.poll();

        ans[0] = arr[ans[0]];
        ans[1] = arr[ans[1]];

        return ans;
    }
}