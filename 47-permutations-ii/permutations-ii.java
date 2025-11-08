class Solution {
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        int[]freq = new int[21];

        for(int i: nums) freq[i+10]++;

        get_ans(freq, new LinkedList<>(), nums);

        return ans;

    }

    public void get_ans(int[]freq, List<Integer>ll, int[]nums){

        if(ll.size() == nums.length){

            ans.add( new LinkedList<>(ll));
            return;

        }

        HashSet<Integer> st = new HashSet<>();

        for(int i : nums){

            if( !st.contains(i) && freq[i+10] != 0){
                st.add(i);
                freq[i+10]--;

                ll.add(i);
                get_ans(freq, ll, nums);
                ll.remove(ll.size()-1);

                freq[i+10]++;
                

            }

        }
    }
}