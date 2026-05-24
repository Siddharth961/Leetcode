class Solution {
    public int minimumEffort(int[][] tasks) {
        
        Arrays.sort(tasks, (a, b) -> {

            int a_diff = a[1] - a[0];
            int b_diff = b[1] - b[0];

            if(a_diff != b_diff) return b_diff - a_diff;

            return b[1] - a[1];
        });

        int bank = 0;
        int rem = 0;

        for(int[] t : tasks){

            if(t[1] > rem){
                bank += (t[1] - rem);
                rem += (t[1] - rem);
            }

            rem -= t[0];
        }

        return bank;
    }
}