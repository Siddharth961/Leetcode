class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        
        if(restrictions.length == 0) return n-1;

        Arrays.sort(restrictions, (a,b) -> a[0] - b[0]);

        int prev_height = 0;
        int prev_idx = 1;

        int last_max_height = 0;

        for(int[]arr : restrictions){

            int d = arr[0] - prev_idx;

            int max_height = prev_height + d;

            arr[1] = Math.min(max_height, arr[1]);

            prev_idx = arr[0];
            prev_height = arr[1];
        }

        // for last index

        last_max_height = Math.min( (prev_height + ( n - prev_idx)), n-1);
        prev_idx = n;
        prev_height = last_max_height;

        // for(int[]arr : restrictions) System.out.println(arr[0] + " "+ arr[1]);
        // System.out.println(n + " " + last_max_height);

        for(int i=restrictions.length-1; i>=0; i--){
            int[]arr = restrictions[i];

            int d =  prev_idx - arr[0];
            int max_height = prev_height + d;

            arr[1] = Math.min(max_height, arr[1] );

            prev_idx = arr[0];
            prev_height = arr[1];
        }

        // for(int[]arr : restrictions) System.out.println(arr[0] + " "+ arr[1]);
        // System.out.println(n + " " + last_max_height);

        int ans = 0;

        prev_idx = 1;
        prev_height = 0;

        for(int[]arr : restrictions){

            int d = arr[0] - prev_idx - 1;

            // d consumed to make heights equal
            d = d - Math.abs(arr[1] - prev_height);

            // possible gain
            int max_possible = Math.max(arr[1], prev_height) + ((d+1)/2);

            ans = Math.max(ans, max_possible);

            prev_idx = arr[0];
            prev_height = arr[1];
        }

        // System.out.println(ans);

        // for nth space

        int d = n - prev_idx - 1;

        // d consumed to make heights equal
        d = d - Math.abs(last_max_height - prev_height);

        // possible gain
        int max_possible = Math.max(last_max_height, prev_height) + ((d+1)/2);

        ans = Math.max(ans, max_possible);

        return ans;
    }
}