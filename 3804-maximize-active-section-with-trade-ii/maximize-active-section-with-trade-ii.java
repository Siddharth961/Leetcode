class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();


        int st = -1;
        int i=0;
        int total_ones = 0;

        for(; i<s.length(); i++){

            if(s.charAt(i) == '0'){

                if(st == -1){
                    st = i;
                    start.add(st);
                }

            }
            else{

                if(st != -1){
                    st = -1;
                    end.add(i-1);
                }
                total_ones++;
            }

        }

        if(st != -1){
            st = -1;
            end.add(i-1);
        }

        // System.out.println(start);
        // System.out.println(end);

        int[] block_size =  new int[start.size()];
        int[] pairs = new int[start.size() > 0 ? start.size() - 1 : 0];

        for(i=0; i<start.size(); i++){
            block_size[i] =  end.get(i) - start.get(i) + 1;

            if(i > 0){
                pairs[i-1] =  block_size[i-1] + block_size[i];
            }
        }
        
        SegmentTree segtree = new SegmentTree(pairs);

        List<Integer>ans = new LinkedList<>();

        for(int[]q : queries){
            int l = q[0];
            int r = q[1];

            int low = lower_bound( l, end);
            int high = upper_bound(r, start) - 1;

            // System.out.println(low + " " + high);

            int maxPairSum = 0;

            if(low < high){

                int firstlen = end.get(low) - Math.max(start.get(low) , l ) + 1;
                int lastlen =  Math.min( r, end.get(high)) - start.get(high) + 1;

                if(high - low == 1){
                    // exact two block

                    maxPairSum = firstlen + lastlen;
                }
                else{

                    int start_two_pair = firstlen + block_size[low+1];
                    int last_two_pair = lastlen + block_size[high-1];
                    int mid_pair = segtree.query_tree( low+1, high-2, pairs.length);

                    maxPairSum = Math.max(start_two_pair, Math.max(last_two_pair, mid_pair) );
                }
            }

            ans.add(maxPairSum + total_ones);
        }

        return ans;

    }

    public int lower_bound(int val, List<Integer> arr){

        int l=0;
        int h=arr.size() - 1;
        int mid = 0;
        int ans = arr.size();

        while( l <= h){
            mid = (l+h)/2;

            if( arr.get(mid) < val){
                l = mid+1;
            }
            else{
                ans = mid;
                h = mid-1;
            }
        }

        return ans;

    }

    public int upper_bound(int val, List<Integer> arr){

        int l=0;
        int h=arr.size() - 1;
        int mid = 0;
        int ans = arr.size();

        while( l <= h){
            mid = (l+h)/2;

            if( arr.get(mid) <= val){
                l = mid+1;
            }
            else{
                ans = mid;
                h = mid-1;
            }
        }

        return ans;

    }

    public class SegmentTree{

        int[]seg_tree;

        public SegmentTree(int[]arr){
            if(arr.length == 0) return;
            int n = arr.length;

            seg_tree = new int[n*4];

            build_tree(0, 0, n-1, arr);
        }

        public int build_tree(int curr, int l, int r, int[]arr){

            if(l == r){
                seg_tree[curr] = arr[l];

                return seg_tree[curr] ;
            }

            
            int mid = (l + r)/2;

            int left = build_tree( 2*curr + 1, l, mid, arr);
            int right = build_tree( 2*curr + 2, mid+1, r, arr);

            seg_tree[curr] = Math.max(left, right);

            return seg_tree[curr] ;

        }

        public int query_tree( int st, int en, int arr_size){

            return query_helper(0, 0, arr_size-1, st, en);
        }

        public int query_helper(int curr, int l, int r, int st, int en){

            if( st <= l && r <= en){

                // the range presented by curr lies fully in target range
                return seg_tree[curr];
            }

            if( st > r || en < l){

                // range presented by curr is FULLY OUT of target range

                return Integer.MIN_VALUE;
            }

            // partial overlap

            int mid = (l + r)/2;

            int left = query_helper( 2*curr + 1, l, mid, st, en);
            int right = query_helper( 2*curr + 2, mid+1, r, st, en);

            return Math.max(left, right);
        }
    }
}