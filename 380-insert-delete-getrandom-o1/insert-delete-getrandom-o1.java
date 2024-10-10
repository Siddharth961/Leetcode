class RandomizedSet {

    ArrayList<Integer>al ;
    HashMap<Integer, Integer> mp;

    public RandomizedSet() {
        al = new ArrayList<>();
        mp = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(mp.containsKey(val) ) return false;
        al.add(val);
        mp.put(val, al.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if( !mp.containsKey(val) ) return false;

        int idx = mp.get(val);

        mp.remove( al.get(idx) );

        if(idx != al.size()-1){

            al.set( idx, al.get(al.size() - 1));
            mp.put( al.get(idx), idx);
        }
        al.remove( al.size() - 1);


        return true;
        
    }
    
    public int getRandom() {
        int random = (int)Math.floor( Math.random()*al.size() );
        return al.get(random);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */