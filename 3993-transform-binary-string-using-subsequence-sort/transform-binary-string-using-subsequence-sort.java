class Solution {
    boolean debug = false;

    public boolean[] transformStr(String s, String[] strs) {

        boolean[]ans = new boolean[strs.length];

        for(int i=0; i<ans.length; i++){
            // dp = new int[s.length()];
            // Arrays.fill(dp, -1);
            // if(i==0){
            //     debug = true;
            //     System.out.println(strs[i]);
            // }
            ans[i] = get_ans( s.toCharArray(), strs[i].toCharArray());
        }

        return ans;
    }

    public boolean get_ans( char[] s, char[] t){

        int one_zero = 0;
        int zero_one = 0;
        int one_mark = 0;

        for(int i=0; i<s.length; i++){

            if(s[i] == '0' && one_zero > 0){
                s[i] = '1';
                one_zero--;
                i--;
                continue;
            }

            if( s[i] == '1' && t[i] == '0'){
                one_zero++;
            }
            if(s[i] == '1' && t[i] == '?'){
                one_mark++;
            }

            if(s[i] == '0' && t[i] == '1'){

                if(one_zero > 0){
                    one_zero--;
                }

                else if(one_mark > 0) one_mark--;
                    
                else return false;
                
            }
        }

        return one_zero == 0;     

        
    }
}