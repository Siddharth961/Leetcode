class Solution {

    HashMap<Integer, Integer> mp = new HashMap<>();

    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> st = new HashSet<>();
        for(int i : nums) st.add(i);

        int ans=0;

        // for(int val : nums){

        //     int len = 0;
        //     int i = val;
        //     while(st.contains(i)){
                
        //         if( looked.containsKey(i) ){
        //             len = looked.get(i);
        //             break;
        //         }

        //         len++;
        //         i++;
        //     }

        //     looked.put(val, len);

        //     ans = Math.max(ans, len);
        // }

        for(int i : st){
            int len =  get_ans(i, st);         

            ans = Math.max(ans, len);
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