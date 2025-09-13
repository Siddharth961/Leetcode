class Solution {
    public boolean isPalindrome(int x) {
        
        if(x < 0 ) return false;

        int num = x;
        int palin = 0;

        while(num > 0){
            palin = palin*10 + num%10;
            num /= 10;
        }

        return x == palin;
    }
}