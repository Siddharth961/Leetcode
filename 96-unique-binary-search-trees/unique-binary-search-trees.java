class Solution {
    public int numTrees(int n) {
        return get_ans(1, n);
    }

    public int get_ans(int st, int en){

        if(st > en) return 1;

        if(st == en) return 1;

        int ans = 0;

        for(int i=st; i<=en; i++){
            
            int val = get_ans( st, i-1) * get_ans(i+1, en);

            // if(i == 2 && st == 1 && en == 3) System.out.println(val);

            ans += val;

        }

        return ans;
    }

}