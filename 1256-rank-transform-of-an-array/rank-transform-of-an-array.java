class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        TreeMap<Integer, List<Integer>> mp = new TreeMap<>();

        for(int i=0; i<arr.length; i++){

            if( !mp.containsKey(arr[i]) ) mp.put(arr[i], new LinkedList<>());
            mp.get(arr[i]).add(i);
        }

        int rank = 1;

        for(int k : mp.keySet()){
            
            for(int idx : mp.get(k)) arr[idx] = rank;

            rank++;
        }

        return arr;
    }
}