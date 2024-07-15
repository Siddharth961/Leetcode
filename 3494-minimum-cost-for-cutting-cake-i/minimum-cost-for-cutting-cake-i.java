class Solution {
    public int minimumCost(int m, int n, int[] h_cut, int[] v_cut) {
        int h_multi = 1;
        int v_multi = 1;

        Arrays.sort(h_cut);
        Arrays.sort(v_cut);

        int i = m-2;
        int j = n-2;

        int cost = 0;

        while(i>=0 && j>=0){

            if(h_cut[i] > v_cut[j]){
                cost += h_cut[i] * h_multi;
                v_multi++;
                i--;
            }
            else{
                cost += v_cut[j] * v_multi;
                h_multi++;
                j--;
            }

        }

        while(i>=0){
            cost += h_cut[i] * h_multi;
            i--;
        }
        while(j>=0){
            cost += v_cut[j] * v_multi;
            j--;
        }

        return cost;
    }
}