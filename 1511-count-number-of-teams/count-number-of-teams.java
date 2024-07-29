class Solution {
    public int numTeams(int[] rating) {
        
        int ans = 0;
        int left = 0;
        int right = 0;

        for(int j=0; j<rating.length; j++){

            left = 0;
            right = 0;

            for(int i=0; i<j; i++){
                if( rating[i] < rating[j]) left ++;
            }

            for(int k=j+1; k<rating.length; k++){
                if(rating[j] < rating[k] ) right++;
            }

            ans += left*right;
        }

        for(int j=0; j<rating.length; j++){

            left = 0;
            right = 0;

            for(int i=0; i<j; i++){
                if( rating[i] > rating[j]) left ++;
            }

            for(int k=j+1; k<rating.length; k++){
                if(rating[j] > rating[k] ) right++;
            }

            ans += left*right;
        }

        return ans;
    }
}