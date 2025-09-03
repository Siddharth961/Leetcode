class Solution {
    int ans_diff = Integer.MAX_VALUE;
    int[]ans_arr;
    public int[] minDifference(int n, int k) {
        
        List<Integer> factors = factorize(n);
        ans_arr = new int[k];

        // System.out.println(factors);

        int[] prods = new int[k];
        Arrays.fill(prods, 1);

        get_ans(0, prods, factors);

        return ans_arr;
    }

    public List<Integer> factorize(int n){
        List<Integer> factors = new ArrayList<>();

        int div = 2;

        while(n > 1){

            while(n > 1 && n % div == 0){
                n = n/div;
                factors.add(div);
            }

            div++;
        }

        return factors;
    }

    public void get_ans(int idx, int[]prods, List<Integer> factors){

        if(idx == factors.size()){
            int min = Integer.MAX_VALUE;
            int max = -1;

            for(int i : prods){  // pof min and max end up on same element
                min = Math.min(min, i );
                max = Math.max(max, i);
            }

            if( ans_diff > max - min){
                ans_diff = max-min;
                for(int i=0; i<prods.length; i++){
                    ans_arr[i] = prods[i];
                }
            }

            return;
        }

        int val = factors.get(idx);

        HashSet<Integer>st = new HashSet<>();

        for(int i=0; i<prods.length; i++){

            if(st.contains(prods[i]) ) continue;

            prods[i] = prods[i]*val;
            get_ans(idx+1, prods, factors);
            prods[i] = prods[i]/val;

            st.add(prods[i]);
        }

    }
}