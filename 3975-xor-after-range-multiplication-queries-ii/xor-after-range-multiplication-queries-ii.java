class Solution {
    int M = 1000000007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        
        int n = nums.length;

        int blockSize = (int)(Math.ceil(Math.sqrt(n)));

        HashMap<Integer, List<int[]>> smallKMap = new HashMap<>();

        for(int[] q : queries){

            int k = q[2];

            // handling large k directly
            if(k >= blockSize){
                for(int i=q[0]; i<=q[1]; i+= k){
                    nums[i] = (int)( (1L * nums[i] * q[3]) % M );
                }
            }

            // storing small k for difference map technique
            else{
                if( !smallKMap.containsKey(k)) smallKMap.put(k, new LinkedList<>());

                smallKMap.get(k).add(q);
            }
        }

        // processing small k one at a time

        for(var k : smallKMap.keySet()){

            long[]diff_arr = new long[n];
            Arrays.fill(diff_arr, 1);

            // making a difference array for all queries with same K
            for(int[]q : smallKMap.get(k)){

                int l = q[0];
                int r = q[1];
                int v = q[3];

                diff_arr[l] = (diff_arr[l] * v) % M;

                int steps = (r - l)/k ;

                int next = l + (steps+1) * k;

                if(next < n){
                    // here we need to mark end of query in diff arr
                    // like diff_arr[next] = (diff_arr[next]/v) % M , but we can not actually do modulo like this so..

                    diff_arr[next] = (diff_arr[next] * power(v, M-2)) % M;
                }
            }

            // making cummulative product array represting impact of all above queries at each index

            for(int i=0; i<n; i++){
                
                if(i-k >= 0){
                    diff_arr[i] = (diff_arr[i] * diff_arr[i-k]) % M; // this is how cummulative arr is made if there jumps .. in this case K
                }
            }

            // making impact in nums

            for(int i=0; i<n; i++){

                nums[i] = (int) ( (1L * nums[i] * diff_arr[i]) % M );
            }
        }


        // Impact of all queries across all K has been made in nums
        // now just need to XOR all elments

        int ans = 0;

        for(int i : nums) ans = ans ^ i;

        return ans;

        

        
    }

    public long power(long a, long b){

        if(b == 0) return 1;

        long half = power(a, b/2);

        long result = (half * half) % M;

        if(b%2 != 0) result = (result * a) % M;

        return result;

    }
}