class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for( char c : s.toCharArray()){
            sb.append(c - 'a' + 1);
        }
        
            // System.out.println(num);
        int num = 0;
        for( char c : sb.toString().toCharArray()){
            num += c - '0';
        }
        k--;
        int n=num;

        while(k>0){
            num = n;
            n = 0;

            while(num > 0){
                n += num%10;
                num = num/10;
            }

            k--;
        }

        return n;

    }
}