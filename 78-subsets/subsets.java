class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        subs(0, nums, al, ans);

        return ans;

    }

    public void subs(int idx, int[]nums, List<Integer> al, List<List<Integer>> ans){
        if(idx == nums.length){
            ans.add(new ArrayList<>(al));
            return;
        }

        subs(idx+1, nums, al, ans);
        al.add(nums[idx]);
        subs(idx+1, nums, al, ans);
        al.remove(al.size()-1);

    }
}