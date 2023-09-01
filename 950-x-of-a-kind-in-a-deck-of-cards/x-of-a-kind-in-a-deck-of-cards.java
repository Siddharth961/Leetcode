class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i:deck){
            mp.put(i, mp.getOrDefault(i,0)+1);
        }

        int val = 0;

        for(int e : mp.values()){
            val = gcd(e,val);
        }
        return val>1;
    }

    public int gcd(int a, int b){
        return b>0 ? gcd(b, a%b) : a;
    }
}