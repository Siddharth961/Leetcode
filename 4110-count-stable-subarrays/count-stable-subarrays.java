class Solution {
    public long[] countStableSubarrays(int[] nums, int[][] queries) {
        
        long[]arr = new long[nums.length];

        for(int i=0; i<nums.length; i++){

            if(i == 0){
                arr[i] = 1;
                continue;
            }

            if(nums[i-1] <= nums[i]) arr[i] = arr[i-1] + 1;
            else arr[i] = 1;
        }


        long[]pre = new long[nums.length];
        pre[0] = arr[0];

        for(int i=1; i<arr.length; i++){

            pre[i] = arr[i] + pre[i-1];

        }

        long[]suf = new long[nums.length];
        for(int i=nums.length-2; i>=0; i--){

            if(arr[i] >= arr[i+1]) suf[i] = 0;
            else suf[i] = suf[i+1] + 1;
        }

        // for(long i : arr) System.out.print(i+" ");
        // System.out.println();
        // for(long i : pre) System.out.print(i+" ");
        // System.out.println();
        // for(long i : suf) System.out.print(i+" ");

        long[]ans = new long[queries.length];

        int idx = 0;
        for(int[]q : queries){

            int l = q[0];
            int r = q[1];

            long val = pre[r];

            if( q[0] > 0){
                val -= pre[ l - 1]; // got prefix sum of required range

                // now minus impact of excluded elements from include elements

                val -= arr[ l-1 ] * Math.min( r-l+1, suf[ l-1 ]);

                // no. of elements making impact * how far they making impact
            }

            ans[idx] = val;
            idx++;
        }

        return ans;
    }
}