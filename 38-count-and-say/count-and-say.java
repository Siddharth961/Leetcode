class Solution {
    public String countAndSay(int n) {
        return helper(n).toString();
    }

    public StringBuilder helper(int n){

        if(n == 1){
            StringBuilder sb = new StringBuilder();
            sb.append('1');
            return sb;
        }

        StringBuilder s = helper(n-1);

        StringBuilder sb = new StringBuilder();

        int count = 1;
        int i=1;
        for(; i<s.length(); i++){

            if( s.charAt(i-1) != s.charAt(i)){

                sb.append(count);
                sb.append( s.charAt(i-1) );
                count = 1;
            }

            else count++;
        }

        sb.append(count);
        sb.append(s.charAt(i-1));

        return sb;


    }
}
