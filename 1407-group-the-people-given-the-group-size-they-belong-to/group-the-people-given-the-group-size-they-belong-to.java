class Solution {
    public List<List<Integer>> groupThePeople(int[] groups) {
        List<List<Integer>> ans = new LinkedList<>();
        HashMap<Integer, List<Integer> > mp = new HashMap<>();

        for(int i=0; i<groups.length; i++){
            if(mp.containsKey(groups[i])==false){
                List<Integer> ll = new LinkedList<>();
                mp.put(groups[i],ll);
                ll.add(i);
            }
            else mp.get(groups[i]).add(i);
            
            if(groups[i]== mp.get(groups[i]).size() ){
                ans.add(mp.get(groups[i]));
                mp.remove(groups[i]);
            }

        }

        return ans;
    }
}