class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        ArrayList<Integer>[] li = new ArrayList[arr.length+1];

        for(int i : arr) mp.put(i, mp.getOrDefault(i,0)+1);

        for(var e : mp.entrySet()){
            int idx = e.getValue();
            if(li[idx]==null) li[idx] = new ArrayList<>();
            li[idx].add(e.getKey());
        }

        int ans=0, size=0;

        for(int i=arr.length; i>0; i--){
            if(li[i]==null) continue;
            for(int j: li[i]){
                ans++;
                size+=i;

                if(size>=arr.length/2) return ans;
            }

        }

        return ans;
    }
}