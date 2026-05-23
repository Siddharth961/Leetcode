class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        
        int[]freq1 = new int[51];
        int[]freq2 = new int[51];

        int[]ans = new int[A.length];

        for(int i=0; i<A.length; i++){

            freq1[ A[i] ]++;
            freq2[ B[i] ]++;

            int val = 0;

            for(int j=0; j<51; j++){
                val += Math.min(freq1[j], freq2[j]);
            }

            ans[i] = val;

        }

        return ans;
    }
}