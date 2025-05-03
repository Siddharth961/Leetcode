class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        int[][]freq = new int[7][3];

        for(int i=0; i<tops.length; i++){

            if(tops[i] != bottoms[i]){

                freq[tops[i]][0]++;
                freq[bottoms[i]][1]++;
            }

            if(tops[i] == bottoms[i]){
                freq[ tops[i] ][2]++;
            }
            else{
                freq[tops[i]][2]++;
                freq[bottoms[i]][2]++;
            }
        }

        int ans = tops.length+1;

        for(int i=1; i<7; i++){

            if( freq[i][2] == tops.length){

                ans = Math.min( ans, Math.min( freq[i][0], freq[i][1] ));

            }

        }

        return ans > tops.length ? -1 : ans;
    }
}