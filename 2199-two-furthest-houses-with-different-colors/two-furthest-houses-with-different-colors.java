class Solution {
    public int maxDistance(int[] colors) {
        
        int pos_after_first = -1;

        int ans = 0;

        for(int i=0; i<colors.length; i++){

            if(colors[i] == colors[0] && pos_after_first != -1){

                ans = Math.max(ans, i - pos_after_first);
            }

            if(colors[i] != colors[0]){

                if(pos_after_first == -1) pos_after_first = i;

                ans = Math.max(ans, i - 0);
            }
        }

        return ans;
    }
}