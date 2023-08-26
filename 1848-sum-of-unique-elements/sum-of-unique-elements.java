class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer,Integer>mp = new HashMap<>();

        for(int i : nums){
            if(mp.containsKey(i)) mp.put(i, mp.get(i)+1);
            else mp.put(i,1);
        }

        int sum=0;
        for(var e: mp.entrySet()){
            if(e.getValue()>1)continue;
            else sum += e.getKey();
        }

        return sum;
    }
}