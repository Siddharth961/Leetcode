class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int f_len = 0;

        int f_i = -1;
        int f_j = -1;

        int[]arr;
        int len = 0;

        for(int i=0; i<s.length(); i++){

            // ans = Math.max(ans, getlen(0, i, s) );
            // ans = Math.max(ans, getlen(1, i, s) );

            arr = getlen(0, i, s);

            len = arr[1] - arr[0] + 1;

            if(len > f_len){
                f_i = arr[0];
                f_j = arr[1];

                f_len = len;
            }


            arr = getlen(1, i, s);

            len = arr[1] - arr[0] + 1;

            if(len > f_len){
                f_i = arr[0];
                f_j = arr[1];

                f_len = len;
            }

        }

        return s.substring(f_i, f_j + 1);
    }

    public int[] getlen( int type, int idx, String s){

        // type = 0 -> evenlen
        // type = 1 -> oddlen

        int i = idx-1;
        int j = type == 0 ? idx : idx+1;

        int len = type == 0 ? 0 : 1;

        while(i>=0 && j<s.length()){

            if( s.charAt(i) == s.charAt(j)){
                i--;
                j++;

                len++;
            }

            else break;
        }

        int[]ans = new int[2];
        ans[0] = i+1;
        ans[1] = j-1;

        // System.out.println(i + " " + j);

        return ans;


    }


}