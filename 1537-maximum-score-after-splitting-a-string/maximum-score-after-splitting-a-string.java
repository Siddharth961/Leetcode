class Solution {
    public int maxScore(String s) {

        char[]arr = s.toCharArray();
        int n = arr.length;

        int[]ones = new int[n];
        int[]zeroes = new int[n];

        int pre = 0;
        for(int i=n-1; i>=0; i--){
            if(arr[i] == '1') pre++;
            ones[i] = pre;
        }
        
        pre = 0;
        for(int i=0; i<n; i++){
            if(arr[i] == '0') pre++;
            zeroes[i] = pre;
        }


        int ans = 0;
        for(int i=1; i<n-1; i++){
            ans = Math.max(ans, ones[i] + zeroes[i]);
        }

        if(ans == 0){
            if(arr[0] == arr[1]) return 1;
            else if( arr[0] == '0') return 2;
        }
        

        return ans;
    }
}