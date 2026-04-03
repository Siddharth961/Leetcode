class Solution {

    long[][][][][][][]dp = new long[20][11][2][2][2][2][200]; // idx, last_digit, tight, started, inc, dec, sum
    String s; // stores range val as string

    boolean[]isGood = new boolean[200];

    public boolean checkGood(int val){

        boolean inc = true;
        boolean dec = true;

        String s = val+"";

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i-1) >= s.charAt(i)) inc = false;
            if(s.charAt(i-1) <= s.charAt(i)) dec = false;

        }

        return inc || dec;

    }
    public long countFancy(long l, long r) {
        
        // first we will check all the possible sum values and store whether they are good
        // since we can have 16 digits sum can go up to 1 + 9^15 = 136 but we will take 200 as limit

        // populating isGood array
        for(int i=0; i<200; i++){
            isGood[i] = checkGood(i);
        }


        // now we will use digit dp to find number of fancy numbers in rages:
        // - (0 ...... l-1 )
        // - (0......... r)

        // then subtract both to get ( l......... r)

        return solve(r) - solve(l-1);


    }

    public long solve(long val){

        // here we will do prep work to start digit dp
        // like reinstantiating our dp since same sp values can not be used for second time, because range change causes tight values to change

        for(var a : dp){
            for(var b: a){
                for(var c: b){
                    for(var d: c){
                        for(var e: d){
                            for(var f : e) Arrays.fill(f, -1);
                        }
                    }
                }
            }
        }

        s = val + "";

        // System.out.println(s);

        return digiDp(0, -1, 1, 0, 1, 1, 0);


    }

    public long digiDp(int idx, int last, int tight, int started, int inc, int dec, int sum){

        if(idx == s.length()){

            if(started == 0){

                // we did not set a single digit
                // hence value is 0, sum is 0
                // so we can return 1 since zero is fancy

                // BUT WHY DID WE USE STARTED?? only so that we wont have to call recursion twice each time to check for increasing series and ecreasing seperatedly

                return 1;
            }

            boolean follows_any_order = (inc == 1) || (dec == 1);
            boolean sum_good = isGood[sum];

            if(follows_any_order || sum_good) return 1;
            return 0;
        }


        // check if we have solved for these parameter before

        //in non started case last needs to be -1, but that would index out of bounds error..so for setting values in dp we use last+1
        long ans = dp[idx][last + 1][tight][started][inc][dec][sum];

        if(ans != -1 ) return ans;
        ans = 0; // IMPORTANT to reset ans back to 0

        int limit = tight == 1 ? s.charAt(idx) - '0' : 9;

        for(int d=0; d<=limit; d++){

            int ntight = (tight == 1 && d == limit) ? 1 : 0; 

            if(started == 0 && d == 0){

                //we havent set any dp nor doing it now - so basically we are not on path of either inc or dec

                ans += digiDp(idx+1, -1, ntight, 0, 1, 1, 0);
            }

            else{

                int ninc = inc;
                int ndec = dec;

                if(started == 1){

                    // only if we had started before this digit then our 'last' would hola true values instead of dummy -1

                    if(last <= d) ndec = 0;
                    if(last >= d) ninc = 0;
                }


                ans += digiDp(idx+1, d, ntight, 1, ninc, ndec, sum + d);
            }
        }

        dp[idx][last + 1][tight][started][inc][dec][sum] = ans;

        return ans;


    }
}