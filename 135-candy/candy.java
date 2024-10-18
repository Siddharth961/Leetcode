class Solution {
    public int candy(int[] ratings) {
        
        int peak = 0;
        int dip = 0;

        int candi = ratings.length;

        int i = 1;

        while(i<ratings.length){

            if(ratings[i-1] == ratings[i]){
                i++;
                continue;
            }

            peak = 0;
            
            while(ratings[i-1] < ratings[i]){
                peak++;
                candi += peak;
                i++;
                if( i == ratings.length) return candi;
            }

            dip = 0;

            while(i<ratings.length && ratings[i-1] > ratings[i]){
                dip++;
                candi += dip;
                i++;
            }

            candi -= Math.min(peak, dip);
        }

        return candi;
    }
}