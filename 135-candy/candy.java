class Solution {
    public int candy(int[] ratings) {

        int n = ratings.length;
        int[]candi_left = new int[n];
        int[]candi_right = new int[n];

        for(int i=0; i<n; i++){
            candi_left[i] = 1;

            if(i==0) continue;

            if(ratings[i-1] < ratings[i]) candi_left[i] += candi_left[i-1];
        }

        for(int i=n-1; i>=0; i--){
            candi_right[i] = 1;

            if(i==n-1) continue;

            if(ratings[i+1] < ratings[i]) candi_right[i] += candi_right[i+1];
        }

        int ans = 0;

        for(int i=0; i<n; i++) ans += Math.max(candi_left[i], candi_right[i]);
        return ans;
    }
}