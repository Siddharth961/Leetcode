class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap< Integer, Integer> mp = new HashMap<>();
        for(int i : arr){
            mp.put(i, mp.getOrDefault(i, 0) + 1);

        }

        PriorityQueue<Integer> ll = new PriorityQueue<>(mp.values());
        // Collections.sort(ll);
        
        while(k>0){
            if(ll.peek()<=k){
                k -= ll.remove();

            }
            else break;
        }

        return ll.size();
    }
}