class RandomizedSet {

    HashMap<Integer, Integer> mp; // val -> idx
    ArrayList<Integer> al; // for O(1) access

    public RandomizedSet() {
        mp = new HashMap<>();
        al = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(mp.containsKey(val) ) return false;



        al.add(val);
        mp.put(val, al.size()-1);

        return true;
    }
    
    public boolean remove(int val) {
        if( !mp.containsKey(val) ) return false;

        int idx = mp.get(val);
        int last_val = al.get(al.size() - 1);

        // System.out.println(al);
        al.set(idx,  last_val);
        mp.put(last_val, idx);

        mp.remove(val);        
        al.remove( al.size() - 1);

        // System.out.println(al);

        return true;
    }
    
    public int getRandom() {
        
        int idx = (int)Math.floor( al.size() * Math.random() );

        return al.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

// hashset or map is needed to check val presence in O(1)
 
//  for O(1) removal - hashmap 
//  for O(1) access - arraylist or array

//  ..lazy loading..