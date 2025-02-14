class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
        
        int max = 0;
        for(int i: groups) max = Math.max(max, i);

        int[]sieve = new int[max+1];

        Arrays.fill(sieve, -1);


        for(int i=0; i<elements.length; i++){

            int e = elements[i];

            if(e <= max && sieve[e] != -1) continue;
            
            while( e < sieve.length ){
                if( sieve[e] == -1) sieve[e] = i;

                e += elements[i];
            }
        }

        int[]ans = new int[groups.length];

        for(int i=0; i<groups.length; i++){
            ans[i] = sieve[ groups[i] ];
        }

        return ans;
    }
}