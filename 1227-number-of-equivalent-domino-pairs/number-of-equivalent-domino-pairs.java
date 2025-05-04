class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[][]freq = new int[10][10];

        int ans = 0;

        for(int[]arr : dominoes){
            
            ans += freq[arr[0]][arr[1]]++;
            

            if(arr[0] != arr[1]){
                ans += freq[arr[1]][arr[0]];
            }

            // System.out.println(ans+"--"+mp);
        }

        return ans;
    }
}