class Solution {
    int[]pre ;
    public long minCost(String s, int encCost, int flatCost) {
        pre = new int[s.length() +1];

        int idx = 1;
        for(int i=0; i<s.length(); i++){
            pre[idx] = pre[idx-1];
            if(s.charAt(i) == '1') pre[idx]++;

            idx++;
        }
        

        return calc(0, s.length()-1, s, encCost, flatCost);
    }

    public long calc(int st, int en, String s, int enc, int flat){

        long cost = 0;

        int ones = pre[en+1] - pre[st];

        int len = en-st+1;
        int mid = (st + en) / 2;

        // for(int i=st; i<=en; i++){
        //     if(s.charAt(i) == '1'){

        //         ones++;
        //     }
        // }

        if(ones != 0){
            // only split if there is atleast single 1 otherwise both splits will still have all zeroes only

            cost = (long) len * ones * enc;

            if(len % 2 == 0){

                long a = calc(st, mid, s, enc, flat);
                long b = calc(mid+1, en, s, enc, flat);

                // if(cost < 0) cost = a+b;

                cost = Math.min(a+b, cost);
                
            }
        }
        else cost = flat;

        // if(cost < 0) System.out.println('1');

        return cost;
    }
}

// there should be at max a single 1 in a segment
// 1 should be there only till L * enc <= flatcost ??