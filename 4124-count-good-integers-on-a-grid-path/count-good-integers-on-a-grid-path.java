class Solution {

    long[][][]dp = new long[16][10][2]; // curr_idx, prev, tight
    public long countGoodIntegersOnPath(long l, long r, String directions) {
        
        List<Integer> list = get_indices(directions);

        String l1 = getString(l-1);
        String r1 = getString(r);

        for(long[][]arr : dp) for(long[]arr2 : arr) Arrays.fill(arr2, -1);
        long a = digiDp(0, 0, 0, 1, l1 , list);

        for(long[][]arr : dp) for(long[]arr2 : arr) Arrays.fill(arr2, -1);

        long b = digiDp(0, 0, 0, 1, r1 , list);

        return b - a;
    }

    public List<Integer> get_indices(String dir){
        List<Integer> list = new ArrayList<>();

        int idx = 0;

        list.add(idx);

        for(int i=0; i<dir.length(); i++){
            char c = dir.charAt(i);

            if(c == 'D') idx += 4;
            else idx++;

            list.add(idx);
        }

        // System.out.println(list);
        return list;
    }

    public String getString(long num){

        String input = num+"";
        int targetLength = 16;

        if (input.length() < targetLength) {
            input = "0".repeat(targetLength - input.length()) + input;
        }

        return input;
    }

    public long digiDp(int c_idx, int curr_idx, int prev, int tight, String num, List<Integer>check_idx){

        if(curr_idx == num.length()) return 1;

        if(dp[curr_idx][prev][tight] != -1) return dp[curr_idx][prev][tight];

        int lo = (c_idx < check_idx.size() && curr_idx == check_idx.get(c_idx) ) ?
                    prev : 0;

        int hi = tight == 1 ? num.charAt(curr_idx) - '0' : 9;

        long ans = 0;

        int next_c_idx = (c_idx < check_idx.size() && curr_idx == check_idx.get(c_idx) ) ?
                            c_idx+1 : c_idx ;




        for(int d = lo; d <= hi; d++){

            int n_tight = (tight == 1 && d == hi) ? 1 : 0;

            int n_prev = next_c_idx != c_idx ? d : prev;
            
            ans += digiDp(next_c_idx, curr_idx+1, n_prev, n_tight, num, check_idx);

        }

        dp[curr_idx][prev][tight] = ans;

        return ans;
    }
}