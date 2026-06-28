class Solution {
    public long maxTotalValue(int[] nums, int k) {

        int n = nums.length;
        
        int[][]st = new int[n*4][2]; // st[i][0] -> min value of rangle, st[i][1] -> max value of range
        buildST(0, 0, n-1, st, nums);

        // Max heap pq
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> b[0] - a[0]); // [val, l , r] -> val is (max - min ) of range [l, r]

        // for each l our best val is if we take furthest r , i.e, a range of [l, n-1] is best for any l, because it will have most elements hence best chance to get lowest min, biggest max

        // at first for each l (0 to n-1) we store best val (i.e of range l,n-1 ) in max heap
        // then we will pop max values .. aka.. best values.. from heap one by one
        // every time we pop we do,
        //       - ans += val and k--
        //       - push( val, l, r-1) .. i.e the NEXT best value for a range starting at l

        for(int l=0; l<n; l++){

            int[]res = queryST(l, n-1, 0, 0, n-1, st);
            int val = res[1] - res[0];
            
            pq.add( new int[]{val, l, n-1});
        }

        long ans = 0;

        while(k > 0){

            int[]arr = pq.remove();
            ans += arr[0];
            k--;

            if( arr[1] < arr[2]){
                
                int[]res = queryST(arr[1], arr[2] - 1, 0, 0, n-1, st);
                int val = res[1] - res[0];

                pq.add( new int[]{val, arr[1], arr[2]-1} );
            }

        }

        return ans;
    }

    public void buildST(int i, int l, int r, int[][]st, int[]nums){

        if(l == r){
            st[i][0] = nums[l];
            st[i][1] = nums[l];

            return;            
        }

        int mid = (l+r)/2;

        int left_child = 2*i +1;
        int right_child = 2*i +2;

        buildST( left_child, l , mid, st, nums);
        buildST( right_child, mid+1 , r, st, nums);

        st[i][0] = Math.min( st[left_child][0] , st[right_child][0] );
        st[i][1] = Math.max( st[left_child][1] , st[right_child][1] );
    }

    public int[] queryST(int st, int end, int i, int l, int r, int[][]segementTree){

        // totally out of range
        if( l > end || r < st ){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        // if completely in range

        if( l >= st && r <= end){
            return segementTree[i]; // st is 2d, returning st[i] - returns array containing min and max

        }

        int mid = (r + l)/2;

        int[]left = queryST(st, end, 2*i + 1, l, mid, segementTree);
        int[]right = queryST(st, end, 2*i + 2, mid+1 , r, segementTree);

        return new int[]{ Math.min(left[0], right[0]), Math.max(left[1], right[1]) };
    }
}