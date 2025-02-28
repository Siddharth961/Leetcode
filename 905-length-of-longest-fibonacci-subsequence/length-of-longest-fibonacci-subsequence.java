class Solution {
    public int lenLongestFibSubseq(int[] arr) {

        int max = 0;
        int n=  arr.length;
        int[][]dp = new int[n][n];

        HashMap<Integer, Integer> mp = new HashMap<>();
        
        for(int i=0; i<n; i++){

            mp.put(arr[i], i);

            for(int j=i+1; j<n; j++){

                int diff = arr[j] - arr[i];

                int idx = mp.getOrDefault(diff, -1);

                // if(i == 1 && j==2 ) System.out.println(dp[0][1]);

                if( idx >= 0 && idx < i){
                    dp[i][j] = dp[idx][i] + 1;
                }
                else dp[i][j] = 2;

                max = Math.max(max, dp[i][j]);

                
            }
        }

        // for(int[]a : dp){
        //     for(int i: a) System.out.print(i+" ");
        //     System.out.println();
        // }

        return max > 2 ? max : 0;
    }
}