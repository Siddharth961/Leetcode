class Solution {
    public boolean isHappy(int n) {
        HashMap<Integer, Boolean>mp = new HashMap<>();
        int val=0;

        while(true){
            if(n==1) return true;
            
            if(mp.containsKey(n)) return false;
            else mp.put(n,false);

            val = n;
            n=0;

            while(val!=0){
                n += Math.pow(val%10,2);
                val=val/10;
            }
            
        }
    }
}