class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int[]arr : edges){
            mp.put( arr[0], mp.getOrDefault(arr[0], 0) + 1);
            mp.put( arr[1], mp.getOrDefault(arr[1], 0) + 1);
        }

        for(var e : mp.keySet()){
            if(mp.get(e) == mp.size( ) - 1 ) return e;
        }

        return 1;
    }
}