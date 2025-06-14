class Solution {
    public int minMaxDifference(int num) {
        
        Stack<Integer> st = new Stack();

        int min_key = -1;
        int min_val = -1;

        int max_key = -1;
        int max_val = -1;

        while(num>0){
            st.push( num%10 );
            num /= 10;
        }

        long min = 0;
        long max = 0;

        long pow = (long)Math.pow( 10, st.size() - 1 );

        while( st.size() > 0){

            int val = st.pop();

            if( max_key == -1 && val < 9){

                max_key = val;
                max_val = 9;

            }

            if( min_key == -1 && val > 0){

                min_key = val;
                min_val = 0;

            }

            if( val == max_key){
                max += 9*pow;
            }
            else max += val*pow;

            if(val != min_key) min += val*pow;

            pow /= 10;
        }

        return (int)(max - min);
    }
}