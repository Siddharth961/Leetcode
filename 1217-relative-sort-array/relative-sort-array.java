class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> mp = new TreeMap<>();

        for(int i : arr1){
            if(mp.containsKey(i)==false) mp.put(i,1);
            else mp.put(i, mp.get(i)+1 );
        }

        int[]ans = new int[arr1.length];
        int i=0;

        for(int k : arr2){
            
            while(mp.get(k)>0){
                ans[i] = k;
                i++;
                mp.put(k, mp.get(k)-1);               
            }
            mp.remove(k);
        }

        
        for(var e : mp.keySet()){
            
            while(mp.get(e)>0){
                ans[i] = e;
                i++;
                mp.put(e, mp.get(e)-1);                                 
            }
        }

        return ans;



    }
}