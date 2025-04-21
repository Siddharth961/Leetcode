class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        
        int min = 0;
        int max = 0;

        int sum = 0;

        for(int i : differences){

            sum += i;

            min = Math.min( min, sum);
            max = Math.max( max, sum);

        }

        int ans = 0;

        for(int i=lower; i<=upper; i++){

            if( i + min >= lower && i + max <= upper ) ans++;

            if(i+max > upper) break;
        }

        return ans;
    }
}