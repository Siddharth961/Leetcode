class Solution {
    public int numOfSubarrays(int[] arr) {

        int pre = 0;
        int odd = 0;
        int even = 0;

        int ans = 0;

        int modulo = 1000000007;

        
        for(int i : arr){

            pre += i;

            if( pre%2 != 0){
                ans = (ans + (1 + even)%modulo) % modulo;

                odd++;
            }
            else{
                ans = (ans + (odd) % modulo) % modulo;

                even++;
            }
        }

        return ans;
    }
}