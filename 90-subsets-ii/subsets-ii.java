class Solution {
    HashSet<List<Integer>> st = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        get_ans(0, new LinkedList<>(), nums);

        List<List<Integer>>ans = new ArrayList<>();
        ans.addAll(st);

        return ans;
    }

    public void get_ans(int idx, List<Integer> list,  int[]nums){

        if(idx == nums.length){
            st.add( new LinkedList<>(list) );
            return;
        }

        list.add(nums[idx]);
        get_ans(idx+1, list, nums);
        list.remove( list.size() - 1);

        get_ans(idx+1, list, nums);
    }
}