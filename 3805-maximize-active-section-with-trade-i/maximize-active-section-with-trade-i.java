class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        
        int ones = 0;
        int convert_zeroes = 0;

        int count_zero = 0;
        int prev_zero = 0;

        for(int i=0; i<s.length(); i++){

            if(s.charAt(i) == '1'){
                ones++;

                if(prev_zero != 0  && count_zero != 0){

                    convert_zeroes = Math.max(convert_zeroes, count_zero + prev_zero);
                }

                if(count_zero != 0) prev_zero = count_zero;
                count_zero = 0;
            }
            else{

                count_zero++;
            }
        }

        if(prev_zero != 0 && count_zero != 0){

            convert_zeroes = Math.max(convert_zeroes, count_zero + prev_zero);
        }

        return ones + convert_zeroes;
    }
}