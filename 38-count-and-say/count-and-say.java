class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";

        String s = countAndSay(n-1);
        if(n == 4) System.out.println(s);

        StringBuilder sb = new StringBuilder();

        int count = 1;

        

        for(int i=1; i<s.length() ; i++){
            if( s.charAt(i-1) != s.charAt(i) ){
                sb.append( count );
                sb.append( s.charAt(i-1) );
                count = 0;

            }

            count++;
        }

         if(n == 4)System.out.println(sb);

        // count++;

        sb.append( count );
        sb.append( s.charAt(s.length() - 1) );

        return sb.toString();

    }


}