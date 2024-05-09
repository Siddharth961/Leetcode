class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);

        long ans = 0;
        int reduct = 0;

        for(int i=happiness.length-1; i>=0 ; i--){
            ans+= (happiness[i] - reduct) > 0 ? (happiness[i] - reduct) : 0;
            reduct++;
            k--;
            if(k==0) break;
        }

        return ans;
    }
}