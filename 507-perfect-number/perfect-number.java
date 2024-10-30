class Solution {
    public boolean checkPerfectNumber(int num) {

        if(num == 1 ) return false;
        int sum = 0;

        int n = (int)Math.sqrt(num);

        for(int i=1; i<=n; i++){
            if(i == 1) sum += 1;
            else{
                if( num%i == 0 ){
                    // System.out.println(i+"--"+n/i);
                    sum += i + num/i;
                }
            }
        }

        return sum == num;
    }
}