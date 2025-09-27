class Solution {
    public int myAtoi(String s) {
        
        long ans = 0;

        int sign  = 0;
        boolean num_encountered = false;

        for(int i=0; i<s.length(); i++){

            char c = s.charAt(i);


            if( (num_encountered || sign != 0) && !(c>='0' && c<='9')){
                break;
            }
            
            if(c == ' ' ) continue;

            else if(c == '-' || c == '+'){

                if(sign != 0) break;

                if(c == '-') sign = -1;
                else sign = 1;
            }

            else if(c>='0' && c<='9'){
                num_encountered = true;
                ans = ans*10 + ( c - '0');
            }

            else break;

            if(ans > Integer.MAX_VALUE){

                break;

            }
        }

        if(sign == 0) sign = 1;

         ans *= sign;

        if( ans < Integer.MIN_VALUE) ans = Integer.MIN_VALUE;
        if( ans > Integer.MAX_VALUE) ans = Integer.MAX_VALUE;

        return (int)ans;
    }
}