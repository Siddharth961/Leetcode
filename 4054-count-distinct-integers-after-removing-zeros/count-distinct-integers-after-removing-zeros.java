class Solution {
    public long countDistinct(long n) {

        int size = 0;
        long div = 1;

        while( n/div > 0){
            size++;
            div *= 10;
        }

        //adding numbers with leading zeroes

        long[]pow = new long[size+1];
        pow[0] = 1;
        for(int i=1; i<=size; i++) pow[i] = pow[i-1] * 9;

        long ans = 0;
        for(int i=1; i<size; i++) ans += pow[i];

        ans += get_ans(n);

        return ans;
    }

    public long get_ans(long n){

        if(n < 10) return n;

        long num = 0;
        int pow = 0;

        while(n >= 10){
            num = (long)( ( n%10 )*Math.pow(10, pow) + num );
            pow++;
            n /= 10;
        }

        // System.out.println(n + " " + num + " " + pow);

        long ans = (n-1) * (long)Math.pow(9, pow);
        if(num >= (long)(Math.pow(10, pow-1)) ) ans += get_ans(num);

        return ans;

    }

    public long get9s(int size){

        long n = 0;
        while(size > 0){
            n = n*10 + 9;
            size--;
        }

        return n;
    }
}