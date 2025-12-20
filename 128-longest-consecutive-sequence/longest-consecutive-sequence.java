class Solution {

    HashMap<Integer, Integer> mp = new HashMap<>();

    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> st = new HashSet<>();
        for(int i : nums) st.add(i);

        int ans=0;


        // for(int i : st){
        //     int len =  get_ans(i, st);         

        //     ans = Math.max(ans, len);
        // }

        //  -------------- START OF SEQUENCE APPROACH -----------------
        // - we only calculate the length of sequence with number x only and only if we are sure x is the START of the sequence, i.e there is NO x-1 element

        for(int i : st){

            if( !st.contains(i-1) ){
                int len = 0;
                int val = i;

                while( st.contains(val)){
                    len++;
                    val++;
                }

                ans = Math.max(ans, len);
            }
        }

        return ans;
    }

    public int get_ans(int val, HashSet<Integer> st){

        if( !st.contains(val) ) return 0;
        if( mp.containsKey(val) ) return mp.get(val);

        int len = get_ans(val + 1, st) + 1;

        mp.put(val, len);

        return len;


    }
}