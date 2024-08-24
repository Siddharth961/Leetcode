class Solution {
    public String nearestPalindromic(String n) {
        
        int len = n.length();
        int half = len%2 == 0 ? len/2 : len/2 +1;

        
        long num = Long.parseLong( n );
        long half_num = Long.parseLong( n.substring(0, half));

        ArrayList<Long> al = new ArrayList<>();

        al.add( (long)Math.pow(10, len) + 1);
        al.add( (long)Math.pow(10, len-1) - 1);
        al.add( get_palin(half_num + 1, len));
        al.add( get_palin(half_num , len));
        al.add( get_palin(half_num - 1, len));

        // System.out.println(al);

        long min = Integer.MAX_VALUE;
        long ans = Integer.MAX_VALUE;

        long diff = 0;

        for(long val : al){

            diff = Math.abs(num-val);
            if(min > diff && num-val != 0){
                min = diff;
                ans = val;
            }
            else if(min == diff) ans = Math.min(ans, val);

        }

        return ans + "";

    }

    public long get_palin(long n, int len){

        long num = n;
        // System.out.println(len+"--"+n);
        if(len % 2 != 0) n /= 10;

        while(n > 0){
            num = num*10 + n%10;
            n /= 10;
        }

        return num;

    }
}