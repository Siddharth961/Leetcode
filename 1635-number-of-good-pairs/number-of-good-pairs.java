class Solution {
    public int numIdenticalPairs(int[] nums) {

        HashMap<Integer,Integer> mp = new HashMap<>();

        int count = 0;

        for(int i : nums){
            if(mp.containsKey(i)==false){
                mp.put(i,1);}
            else{
                count+= mp.get(i);
                mp.put(i, mp.get(i)+1);
            }

        }

        return count;
        
    }
}