class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int size = 0;
        for(int i : nums){
            if(mp.containsKey(i)) mp.put(i, mp.get(i)+1);
            else mp.put(i,1);
            
            if(size<mp.get(i)) size = mp.get(i);
        }

        List<List<Integer>> ans = new LinkedList<>();

        while(size>0){
            ans.add(new LinkedList<Integer>());
            size--;
        }

        for(var e : mp.entrySet()){
            int j = e.getValue();
            for(int i=0; i<j; i++){
                ans.get(i).add(e.getKey());
            }
        }

        return ans;
    }
}