class Solution {
    public int numSteps(String s) {
        char[]arr = s.toCharArray();
        int ans = s.length()-1;
        int carry = 0;

        for(int i=arr.length-1; i>0; i--){

            if(arr[i] - '0' + carry == 1){
                ans++;
                carry = 1;
            }
        }

        return ans + carry;
    }
}