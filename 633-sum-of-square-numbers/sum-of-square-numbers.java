class Solution {
    public boolean judgeSquareSum(int c) {
        long i=0;
        long j=0;
        long mid = 0;

        

        for(long a = 0; a*a<=c; a++){

            i = a;
            j =(long) Math.sqrt(c);

            while(i<=j){
                mid = (j+i)/2;
                if(a*a + mid*mid == c ) return true;
                else if(a*a + mid*mid < c ) i=mid+1;
                else j=mid-1;

            }
        }

        return false;
    }
}