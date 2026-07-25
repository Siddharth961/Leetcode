class Solution {
    public long sumAndMultiply(int n) {
        
        long num = 0;
        long sum = 0;

        String s = n+"";

        for(int i=0; i<s.length(); i++){

            int val = s.charAt(i) - '0';

            if(val != 0){
                num = num*10 + val;
                sum += val;
            }
        }

        return num * sum;
    }
}