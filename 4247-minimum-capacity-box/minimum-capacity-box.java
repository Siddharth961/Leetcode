class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int ans = -1;
        int val = Integer.MAX_VALUE;

        for(int i=0; i<capacity.length; i++){
            if( capacity[i] >= itemSize && val > capacity[i]){
                ans = i;
                val = capacity[i];
            }
        }

        return ans;
    }
}