class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> combinationSum2(int[] candi, int tar) {
        Arrays.sort(candi);
        List<Integer> al = new ArrayList<>();

        sol(0, candi, tar,0, al);


        return ans;
    }

    public void sol (int idx, int[]candi, int tar, int ssf, List<Integer> al){
        if(ssf==tar){
            List<Integer> temp = new ArrayList<>(al);
            ans.add(temp);
            return;
        }
        if(ssf>tar) return;

        int prev = -1;

        for(int i=idx; i<candi.length; i++){
            if(prev==candi[i]) continue;
            al.add(candi[i]);
            sol(i+1, candi, tar, ssf + candi[i], al);
            al.remove(al.size()-1);
            prev = candi[i];
        }


    }
}