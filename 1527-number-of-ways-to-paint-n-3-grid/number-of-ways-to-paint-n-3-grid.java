class Solution {
    public int numOfWays(int n) {
        return colorTheGrid(3, n);
    }

    int modulo = 1000000007;
    public int colorTheGrid(int m, int n) {
        
        List<String> possible_columns = new ArrayList<>();
        get_states(new StringBuilder(), new char[]{'R', 'G', 'B'}, m, possible_columns);

        HashMap<Integer , HashMap<String, Integer> > dp = new HashMap<>();

        // System.out.println(possible_columns);

        return get_ans("", 0, n, possible_columns, dp);
    }

    public void get_states(StringBuilder ssf, char[]choices, int len, List<String>list){

        if(ssf.length() == len){

        // System.out.println(ssf);
            list.add(ssf.toString());
            return;

        }

        for(char c : choices){
            if(ssf.length() > 0 &&  ssf.charAt( ssf.length() - 1) == c ){
                continue;
            }

            ssf.append( c );
            get_states(ssf, choices, len, list);
            ssf.deleteCharAt(ssf.length() - 1);
        }


    }

    public int get_ans(String prev_column, int curr, int total_column, List<String> choices,  HashMap<Integer , HashMap<String, Integer>>  dp){

        if( curr == total_column ){
            return 1;
        }

        if(dp.containsKey( curr )){
            var mp = dp.get(curr);

            if( mp.containsKey(prev_column) ) return mp.get(prev_column);
        }

        

        int ans = 0;
        for(String s : choices){

            boolean valid = true;

            for(int i=0; i<s.length(); i++){
                if(prev_column.length() > 0 && s.charAt(i) == prev_column.charAt(i)){
                    valid = false;
                    break;
                }
            }

            if(valid){
                ans = (ans + get_ans(s, curr+1, total_column, choices, dp)) % modulo;
            }
        }

        if(!dp.containsKey(curr)) dp.put(curr, new HashMap<>() );

        dp.get(curr).put( prev_column, ans);

        return ans;
    }
}