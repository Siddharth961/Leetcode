class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer , Integer> mp = new HashMap<>();

        for(int i : nums){
            mp.put( i, mp.getOrDefault(i, 0) + 1);
        }

        int[]freq = new int[nums.length + 1]; 

        for( var e : mp.keySet()){
            freq[ mp.get(e) ] += mp.get(e); 
        }

        for(int i=freq.length-1; i>=0 ; i--) if(freq[i]>0){
           
             return freq[i];
            }

        return 1;
    }
}