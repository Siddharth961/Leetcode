class Solution {
    public int totalWaviness(int num1, int num2) {
        num1 = Math.max(101, num1);

        int ans = 0;
        
        for(int i=num1; i<=num2; i++){

            ans += calcWaviness(i);

        }

        return ans;
    }

    public int calcWaviness(int n){

        String s = n+"";

        int val = 0;

        for(int i=1; i<s.length()-1; i++){

            char prev = s.charAt(i-1);
            char curr = s.charAt(i);
            char next = s.charAt(i+1);

            if(prev < curr && curr > next) val++;
            if(prev > curr && curr < next) val++;
        }

        return val;
    }
}