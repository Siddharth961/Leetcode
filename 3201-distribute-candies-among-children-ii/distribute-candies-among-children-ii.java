class Solution {
    public long distributeCandies(int n, int limit) {
        
        long ans = 0;

        int f_limit = Math.min(n, limit);

        for(int i=0; i<= f_limit; i++){

            int rem = n - i;

            if( rem > 2*limit) continue;

            // System.out.print(i +" --- ");

            int lower = Math.max(0, rem - limit);
            int upper = Math.min( rem , limit);

            // System.out.print(lower + " " + upper);

            // System.out.println();

            ans += upper - lower + 1;
        }

        return ans;
    }
}