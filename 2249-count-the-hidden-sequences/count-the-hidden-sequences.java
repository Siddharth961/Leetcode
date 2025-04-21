class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        
        long min = 0;
        long max = 0;

        long sum = 0;

        for(int i : differences){

            sum += i;

            min = Math.min( min, sum);
            max = Math.max( max, sum);

        }

        long ans = 0;

        // for(int i=lower; i<=upper; i++){

        //     if( i + min >= lower && i + max <= upper ) ans++;

        //     if(i+max > upper) break;
        // }

        // System.out.println(differences.length);

        ans = (upper - max) -  ( lower - min) + 1;

        return ans>0 ? (int)ans : 0;
    }
}