class Solution {
    long[][][][][]dp_nums = new long[16][2][11][11][2];
    long[][][][][]dp_waves = new long[16][2][11][11][2];

    public long totalWaviness(long num1, long num2) {
        
        String s1 = (num1-1) + "";
        for(long[][][][]a : dp_nums) for(long[][][]b : a) for(long[][]c : b) for(long[]d : c) Arrays.fill(d, -1);
        for(long[][][][]a : dp_waves) for(long[][][]b : a) for(long[][]c : b) for(long[]d : c) Arrays.fill(d, -1);

        long val1 = digiDp(0, 1, 10, 10, 0, s1)[1];

        for(long[][][][]a : dp_nums) for(long[][][]b : a) for(long[][]c : b) for(long[]d : c) Arrays.fill(d, -1);
        for(long[][][][]a : dp_waves) for(long[][][]b : a) for(long[][]c : b) for(long[]d : c) Arrays.fill(d, -1);
        long val2 = digiDp(0, 1, 10, 10, 0, num2+"")[1];

        return val2 - val1;
    }

    public long[] digiDp( int idx, int tight, int prev, int second_prev, int started, String num){

        if(idx == num.length()){
            return new long[]{1, 0}; // number making complete, no wave to add
        }

        // if(tight == 0 && started == 0){

        // }
        if( dp_nums[idx][tight][prev][second_prev][started] != -1) return new long[]{dp_nums[idx][tight][prev][second_prev][started], dp_waves[idx][tight][prev][second_prev][started]};


        int limit = tight == 1 ? num.charAt(idx) - '0' : 9;

        long total_nums = 0;
        long total_waves = 0;
        
        for(int digit = 0; digit <= limit; digit++){

            int ntight = (tight == 1 && digit == limit) ? 1 : 0;

            int nstarted = (started == 1 || digit !=0) ? 1 : 0;

            int nsecond_prev = prev;
            int nprev = nstarted == 1 ? digit : prev;


            long[]val = digiDp(idx+1, ntight, nprev, nsecond_prev, nstarted, num);

            long recieved_nums = val[0];
            long recieved_waves = val[1];

            if( started == 1 && prev != 10 && second_prev != 10){

                if( (second_prev < prev && prev > digit) || (second_prev > prev && prev < digit) ){
                    total_waves += 1 * recieved_nums;
                }

            }

            total_nums += recieved_nums;
            total_waves += recieved_waves;


        }

         dp_nums[idx][tight][prev][second_prev][started] = total_nums;
         dp_waves[idx][tight][prev][second_prev][started] = total_waves;


        return new long[]{total_nums, total_waves};
    }
}