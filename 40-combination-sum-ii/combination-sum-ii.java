class Solution {
    List<List<Integer>> ans = new LinkedList<>();
    HashSet<String> st = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        get_ans(0, new LinkedList<>(), target, candidates);

        return ans;
    }

    public void get_ans(int idx, List<Integer> list, int tar, int[]nums){

        if(tar == 0){
            // String s = list.toString();

            // if(!st.contains(s)){
            //     st.add(s);
            // }
                ans.add( new LinkedList<>(list) );

                return;
        }

        if(idx == nums.length || tar < 0) return;


        list.add(nums[idx]);
        get_ans(idx+1, list, tar - nums[idx], nums);
        list.remove(list.size()-1);

        int i = idx;

        while(i < nums.length && nums[i] == nums[idx]) i++;

        get_ans(i, list, tar , nums);

    }
}