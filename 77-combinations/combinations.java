class Solution {
    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        get_ans(1, n, k, new LinkedList());
        return ans;
    }

    public void get_ans(int curr, int n, int k, List<Integer> list){

        if(list.size() == k){
            ans.add( new LinkedList(list));
            return;
        }

        if( curr > n ){
            return ;
        }

        get_ans(curr+1, n, k, list);

        list.add(curr);
        get_ans(curr+1, n, k, list);
        list.remove(list.size()-1);
    }
}