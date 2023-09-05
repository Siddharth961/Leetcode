class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();

        for(int i=0; i<s.length(); i++) mp.put(s.charAt(i) , i);
        int part = 0;
        int count=0;

        for(int i=0; i<s.length(); i++){
            int x = mp.get(s.charAt(i)); 
            if(part<x) part=x;
            
            count++;

            if(i==part){
                al.add(count);
                count=0;
            }

        }

        return al;
    }
}